/*
 * The MIT License (MIT)
 * Copyright (c) 2018 Microsoft Corporation
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.azure.data.cosmos.internal;

import com.azure.data.cosmos.ConnectionMode;
import com.azure.data.cosmos.ConnectionPolicy;
import com.azure.data.cosmos.ConsistencyLevel;
import com.azure.data.cosmos.internal.directconnectivity.Protocol;
import com.azure.data.cosmos.internal.directconnectivity.ReflectionUtils;
import com.azure.data.cosmos.internal.http.HttpClient;
import com.azure.data.cosmos.internal.http.HttpHeaders;
import com.azure.data.cosmos.internal.http.HttpRequest;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.spy;

public class SpyClientUnderTestFactory {

    public static abstract class SpyBaseClass<T> extends RxDocumentClientImpl {

        public SpyBaseClass(URI serviceEndpoint, String masterKeyOrResourceToken, ConnectionPolicy connectionPolicy, ConsistencyLevel consistencyLevel, Configs configs) {
            super(serviceEndpoint, masterKeyOrResourceToken, connectionPolicy, consistencyLevel, configs);
        }
        
        public abstract List<T> getCapturedRequests();
        
        public abstract void clearCapturedRequests();

        protected static Configs createConfigsSpy(final Protocol protocol) {
            final Configs configs = spy(new Configs());
            doAnswer((Answer<Protocol>) invocation -> protocol).when(configs).getProtocol();
            return configs;
        }
    }
    
    public static class ClientWithGatewaySpy extends SpyBaseClass<RxDocumentServiceRequest> {

        private RxGatewayStoreModel origRxGatewayStoreModel;
        private RxGatewayStoreModel spyRxGatewayStoreModel;

        private List<RxDocumentServiceRequest> requests;


        ClientWithGatewaySpy(URI serviceEndpoint, String masterKey, ConnectionPolicy connectionPolicy, ConsistencyLevel consistencyLevel, Configs configs) {
            super(serviceEndpoint, masterKey, connectionPolicy, consistencyLevel, configs);
            init();
        }

        @Override
        public List<RxDocumentServiceRequest> getCapturedRequests() {
            return requests;
        }

        @Override
        RxGatewayStoreModel createRxGatewayProxy(ISessionContainer sessionContainer,
                                                 ConsistencyLevel consistencyLevel,
                                                 QueryCompatibilityMode queryCompatibilityMode,
                                                 UserAgentContainer userAgentContainer,
                                                 GlobalEndpointManager globalEndpointManager,
                                                 HttpClient rxClient) {
            this.origRxGatewayStoreModel = super.createRxGatewayProxy(
                    sessionContainer,
                    consistencyLevel,
                    queryCompatibilityMode,
                    userAgentContainer,
                    globalEndpointManager,
                    rxClient);
            this.requests = Collections.synchronizedList(new ArrayList<>());
            this.spyRxGatewayStoreModel = spy(this.origRxGatewayStoreModel);
            this.initRequestCapture();
            return this.spyRxGatewayStoreModel;
        }

        protected void initRequestCapture() {
            doAnswer(new Answer() {
                @Override
                public Object answer(InvocationOnMock invocationOnMock)  {
                    RxDocumentServiceRequest req = invocationOnMock.getArgumentAt(0, RxDocumentServiceRequest.class);
                    requests.add(req);
                    return ClientWithGatewaySpy.this.origRxGatewayStoreModel.processMessage(req);
                }
            }).when(ClientWithGatewaySpy.this.spyRxGatewayStoreModel).processMessage(Mockito.any(RxDocumentServiceRequest.class));
        }

        @Override
        public void clearCapturedRequests() {
            requests.clear();
        }

        public RxGatewayStoreModel getSpyGatewayStoreModel() {
            return spyRxGatewayStoreModel;
        }

        public RxGatewayStoreModel getOrigGatewayStoreModel() {
            return origRxGatewayStoreModel;
        }
    }

    public static class ClientUnderTest extends SpyBaseClass<HttpRequest> {

        HttpClient origHttpClient;
        HttpClient spyHttpClient;
        List<Pair<HttpRequest, Future<HttpHeaders>>> requestsResponsePairs =
                Collections.synchronizedList(new ArrayList<>());

        ClientUnderTest(URI serviceEndpoint, String masterKey, ConnectionPolicy connectionPolicy, ConsistencyLevel consistencyLevel, Configs configs) {
            super(serviceEndpoint, masterKey, connectionPolicy, consistencyLevel, configs);
            init();
        }

        public List<Pair<HttpRequest, Future<HttpHeaders>>> capturedRequestResponseHeaderPairs() {
            return requestsResponsePairs;
        }

        @Override
        public List<HttpRequest> getCapturedRequests() {
            return requestsResponsePairs.stream().map(Pair::getLeft).collect(Collectors.toList());
        }

        void initRequestCapture(HttpClient spyClient) {
            doAnswer(invocationOnMock -> {
                HttpRequest httpRequest = invocationOnMock.getArgumentAt(0, HttpRequest.class);
                CompletableFuture<HttpHeaders> f = new CompletableFuture<>();
                requestsResponsePairs.add(Pair.of(httpRequest, f));

                return origHttpClient
                        .send(httpRequest)
                        .doOnNext(httpResponse -> f.complete(httpResponse.headers()))
                        .doOnError(f::completeExceptionally);
            }).when(spyClient).send(Mockito.any(HttpRequest.class));
        }

        @Override
        public void clearCapturedRequests() {
            requestsResponsePairs.clear();
        }

        public ISessionContainer getSessionContainer() {
            try {
                return (ISessionContainer) FieldUtils.readField(this, "sessionContainer", true);
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        }

        public HttpClient getSpyHttpClient() {
            return spyHttpClient;
        }
    }

    public static class DirectHttpsClientUnderTest extends SpyBaseClass<HttpRequest> {

        HttpClient origHttpClient;
        HttpClient spyHttpClient;
        List<Pair<HttpRequest, Future<HttpHeaders>>> requestsResponsePairs =
                Collections.synchronizedList(new ArrayList<>());

        DirectHttpsClientUnderTest(URI serviceEndpoint, String masterKey, ConnectionPolicy connectionPolicy, ConsistencyLevel consistencyLevel) {
            super(serviceEndpoint, masterKey, connectionPolicy, consistencyLevel, createConfigsSpy(Protocol.HTTPS));
            assert connectionPolicy.connectionMode() == ConnectionMode.DIRECT;
            init();

            this.origHttpClient = ReflectionUtils.getDirectHttpsHttpClient(this);
            this.spyHttpClient = spy(this.origHttpClient);
            ReflectionUtils.setDirectHttpsHttpClient(this, this.spyHttpClient);
            this.initRequestCapture(this.spyHttpClient);
        }

        public List<Pair<HttpRequest, Future<HttpHeaders>>> capturedRequestResponseHeaderPairs() {
            return requestsResponsePairs;
        }

        @Override
        public List<HttpRequest> getCapturedRequests() {
            return requestsResponsePairs.stream().map(Pair::getLeft).collect(Collectors.toList());
        }

        void initRequestCapture(HttpClient spyClient) {
            doAnswer(invocationOnMock -> {
                HttpRequest httpRequest = invocationOnMock.getArgumentAt(0, HttpRequest.class);
                CompletableFuture<HttpHeaders> f = new CompletableFuture<>();
                requestsResponsePairs.add(Pair.of(httpRequest, f));

                return origHttpClient
                        .send(httpRequest)
                        .doOnNext(httpResponse -> f.complete(httpResponse.headers()))
                        .doOnError(f::completeExceptionally);

            }).when(spyClient).send(Mockito.any(HttpRequest.class));
        }

        @Override
        public void clearCapturedRequests() {
            requestsResponsePairs.clear();
        }

        public ISessionContainer getSessionContainer() {
            try {
                return (ISessionContainer) FieldUtils.readField(this, "sessionContainer", true);
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        }

        public HttpClient getSpyHttpClient() {
            return spyHttpClient;
        }
    }
    
    public static ClientWithGatewaySpy createClientWithGatewaySpy(AsyncDocumentClient.Builder builder) {
        return new SpyClientBuilder(builder).buildWithGatewaySpy();
    }

    public static ClientWithGatewaySpy createClientWithGatewaySpy(URI serviceEndpoint,
                                                                  String masterKey,
                                                                  ConnectionPolicy connectionPolicy,
                                                                  ConsistencyLevel consistencyLevel,
                                                                  Configs configs) {
        return new ClientWithGatewaySpy(serviceEndpoint, masterKey, connectionPolicy, consistencyLevel, configs);
    }

    public static ClientUnderTest createClientUnderTest(AsyncDocumentClient.Builder builder) {
        return new SpyClientBuilder(builder).build();
    }
    
    public static DirectHttpsClientUnderTest createDirectHttpsClientUnderTest(AsyncDocumentClient.Builder builder) {
        return new SpyClientBuilder(builder).buildWithDirectHttps();
    }

    public static ClientUnderTest createClientUnderTest(URI serviceEndpoint,
                                                        String masterKey,
                                                        ConnectionPolicy connectionPolicy,
                                                        ConsistencyLevel consistencyLevel,
                                                        Configs configs) {
        return new ClientUnderTest(serviceEndpoint, masterKey, connectionPolicy, consistencyLevel, configs) {

            @Override
            RxGatewayStoreModel createRxGatewayProxy(ISessionContainer sessionContainer,
                                                     ConsistencyLevel consistencyLevel,
                                                     QueryCompatibilityMode queryCompatibilityMode,
                                                     UserAgentContainer userAgentContainer,
                                                     GlobalEndpointManager globalEndpointManager,
                                                     HttpClient rxClient) {

                HttpClient spy = spy(rxClient);

                this.origHttpClient = rxClient;
                this.spyHttpClient = spy;

                this.initRequestCapture(spyHttpClient);

                return super.createRxGatewayProxy(
                        sessionContainer,
                        consistencyLevel,
                        queryCompatibilityMode,
                        userAgentContainer,
                        globalEndpointManager,
                        spy);
            }
        };
    }

    public static DirectHttpsClientUnderTest createDirectHttpsClientUnderTest(URI serviceEndpoint, String masterKey,
            ConnectionPolicy connectionPolicy, ConsistencyLevel consistencyLevel) {
        return new DirectHttpsClientUnderTest(serviceEndpoint, masterKey, connectionPolicy, consistencyLevel);
    }
}
