/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.dataplane.monitor.implementation;

import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureClient;
import com.microsoft.azure.AzureServiceClient;
import com.microsoft.azure.dataplane.monitor.AzureMetricsDocument;
import com.microsoft.azure.dataplane.monitor.MicrosoftAspNetCoreMvcObjectResultInnerException;
import com.microsoft.rest.credentials.ServiceClientCredentials;
import com.microsoft.rest.RestClient;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.Validator;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * Initializes a new instance of the AzureMetricsClientImpl class.
 */
public class AzureMetricsClientImpl extends AzureServiceClient {
    /** The Retrofit service to perform REST calls. */
    private AzureMetricsClientService service;
    /** the {@link AzureClient} used for long running operations. */
    private AzureClient azureClient;

    /**
     * Gets the {@link AzureClient} used for long running operations.
     * @return the azure client;
     */
    public AzureClient getAzureClient() {
        return this.azureClient;
    }

    /** Gets or sets the preferred language for the response. */
    private String acceptLanguage;

    /**
     * Gets Gets or sets the preferred language for the response.
     *
     * @return the acceptLanguage value.
     */
    public String acceptLanguage() {
        return this.acceptLanguage;
    }

    /**
     * Sets Gets or sets the preferred language for the response.
     *
     * @param acceptLanguage the acceptLanguage value.
     * @return the service client itself
     */
    public AzureMetricsClientImpl withAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
        return this;
    }

    /** Gets or sets the retry timeout in seconds for Long Running Operations. Default value is 30. */
    private int longRunningOperationRetryTimeout;

    /**
     * Gets Gets or sets the retry timeout in seconds for Long Running Operations. Default value is 30.
     *
     * @return the longRunningOperationRetryTimeout value.
     */
    public int longRunningOperationRetryTimeout() {
        return this.longRunningOperationRetryTimeout;
    }

    /**
     * Sets Gets or sets the retry timeout in seconds for Long Running Operations. Default value is 30.
     *
     * @param longRunningOperationRetryTimeout the longRunningOperationRetryTimeout value.
     * @return the service client itself
     */
    public AzureMetricsClientImpl withLongRunningOperationRetryTimeout(int longRunningOperationRetryTimeout) {
        this.longRunningOperationRetryTimeout = longRunningOperationRetryTimeout;
        return this;
    }

    /** When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true. */
    private boolean generateClientRequestId;

    /**
     * Gets When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true.
     *
     * @return the generateClientRequestId value.
     */
    public boolean generateClientRequestId() {
        return this.generateClientRequestId;
    }

    /**
     * Sets When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true.
     *
     * @param generateClientRequestId the generateClientRequestId value.
     * @return the service client itself
     */
    public AzureMetricsClientImpl withGenerateClientRequestId(boolean generateClientRequestId) {
        this.generateClientRequestId = generateClientRequestId;
        return this;
    }

    /**
     * Initializes an instance of AzureMetricsClient client.
     *
     * @param credentials the management credentials for Azure
     */
    public AzureMetricsClientImpl(ServiceClientCredentials credentials) {
        this("https://monitoring.azure.com", credentials);
    }

    /**
     * Initializes an instance of AzureMetricsClient client.
     *
     * @param baseUrl the base URL of the host
     * @param credentials the management credentials for Azure
     */
    public AzureMetricsClientImpl(String baseUrl, ServiceClientCredentials credentials) {
        super(baseUrl, credentials);
        initialize();
    }

    /**
     * Initializes an instance of AzureMetricsClient client.
     *
     * @param restClient the REST client to connect to Azure.
     */
    public AzureMetricsClientImpl(RestClient restClient) {
        super(restClient);
        initialize();
    }

    protected void initialize() {
        this.acceptLanguage = "en-US";
        this.longRunningOperationRetryTimeout = 30;
        this.generateClientRequestId = true;
        this.azureClient = new AzureClient(this);
        initializeService();
    }

    /**
     * Gets the User-Agent header for the client.
     *
     * @return the user agent string.
     */
    @Override
    public String userAgent() {
        return String.format("%s (%s, %s)", super.userAgent(), "AzureMetricsClient", "2018-09-01-preview");
    }

    private void initializeService() {
        service = restClient().retrofit().create(AzureMetricsClientService.class);
    }

    /**
     * The interface defining all the services for AzureMetricsClient to be
     * used by Retrofit to perform actually REST calls.
     */
    interface AzureMetricsClientService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.dataplane.monitor.AzureMetricsClient azureMonitorCustomMetricsIngestionApi" })
        @POST("subscriptions/{subscriptionId}/resourcegroups/{resourceGroupName}/providers/{resourceProvider}/{resourceTypeName}/{resourceName}/metrics")
        Observable<Response<ResponseBody>> azureMonitorCustomMetricsIngestionApi(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("resourceProvider") String resourceProvider, @Path("resourceTypeName") String resourceTypeName, @Path("resourceName") String resourceName, @Header("Content-Type") String contentType, @Header("Content-Length") Integer contentLength, @Body AzureMetricsDocument body, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Ingestion API used by Azure custom metrics
                 Responsible of below operation
                 1. Authorize the request
                 2. Deserialize payload request body
                 3. Perform validation of the payload
                 4. Commits the payload for metrics ingestion.
     *
     * @param subscriptionId The azure subscription id
     * @param resourceGroupName The ARM resource group name
     * @param resourceProvider The ARM resource provider name
     * @param resourceTypeName The ARM resource type name
     * @param resourceName The ARM resource name
     * @param body The Azure metrics document json payload
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws MicrosoftAspNetCoreMvcObjectResultInnerException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the MicrosoftAspNetCoreMvcObjectResultInner object if successful.
     */
    public MicrosoftAspNetCoreMvcObjectResultInner azureMonitorCustomMetricsIngestionApi(String subscriptionId, String resourceGroupName, String resourceProvider, String resourceTypeName, String resourceName, AzureMetricsDocument body) {
        return azureMonitorCustomMetricsIngestionApiWithServiceResponseAsync(subscriptionId, resourceGroupName, resourceProvider, resourceTypeName, resourceName, body).toBlocking().single().body();
    }

    /**
     * Ingestion API used by Azure custom metrics
                 Responsible of below operation
                 1. Authorize the request
                 2. Deserialize payload request body
                 3. Perform validation of the payload
                 4. Commits the payload for metrics ingestion.
     *
     * @param subscriptionId The azure subscription id
     * @param resourceGroupName The ARM resource group name
     * @param resourceProvider The ARM resource provider name
     * @param resourceTypeName The ARM resource type name
     * @param resourceName The ARM resource name
     * @param body The Azure metrics document json payload
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<MicrosoftAspNetCoreMvcObjectResultInner> azureMonitorCustomMetricsIngestionApiAsync(String subscriptionId, String resourceGroupName, String resourceProvider, String resourceTypeName, String resourceName, AzureMetricsDocument body, final ServiceCallback<MicrosoftAspNetCoreMvcObjectResultInner> serviceCallback) {
        return ServiceFuture.fromResponse(azureMonitorCustomMetricsIngestionApiWithServiceResponseAsync(subscriptionId, resourceGroupName, resourceProvider, resourceTypeName, resourceName, body), serviceCallback);
    }

    /**
     * Ingestion API used by Azure custom metrics
                 Responsible of below operation
                 1. Authorize the request
                 2. Deserialize payload request body
                 3. Perform validation of the payload
                 4. Commits the payload for metrics ingestion.
     *
     * @param subscriptionId The azure subscription id
     * @param resourceGroupName The ARM resource group name
     * @param resourceProvider The ARM resource provider name
     * @param resourceTypeName The ARM resource type name
     * @param resourceName The ARM resource name
     * @param body The Azure metrics document json payload
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the MicrosoftAspNetCoreMvcObjectResultInner object
     */
    public Observable<MicrosoftAspNetCoreMvcObjectResultInner> azureMonitorCustomMetricsIngestionApiAsync(String subscriptionId, String resourceGroupName, String resourceProvider, String resourceTypeName, String resourceName, AzureMetricsDocument body) {
        return azureMonitorCustomMetricsIngestionApiWithServiceResponseAsync(subscriptionId, resourceGroupName, resourceProvider, resourceTypeName, resourceName, body).map(new Func1<ServiceResponse<MicrosoftAspNetCoreMvcObjectResultInner>, MicrosoftAspNetCoreMvcObjectResultInner>() {
            @Override
            public MicrosoftAspNetCoreMvcObjectResultInner call(ServiceResponse<MicrosoftAspNetCoreMvcObjectResultInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Ingestion API used by Azure custom metrics
                 Responsible of below operation
                 1. Authorize the request
                 2. Deserialize payload request body
                 3. Perform validation of the payload
                 4. Commits the payload for metrics ingestion.
     *
     * @param subscriptionId The azure subscription id
     * @param resourceGroupName The ARM resource group name
     * @param resourceProvider The ARM resource provider name
     * @param resourceTypeName The ARM resource type name
     * @param resourceName The ARM resource name
     * @param body The Azure metrics document json payload
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the MicrosoftAspNetCoreMvcObjectResultInner object
     */
    public Observable<ServiceResponse<MicrosoftAspNetCoreMvcObjectResultInner>> azureMonitorCustomMetricsIngestionApiWithServiceResponseAsync(String subscriptionId, String resourceGroupName, String resourceProvider, String resourceTypeName, String resourceName, AzureMetricsDocument body) {
        if (subscriptionId == null) {
            throw new IllegalArgumentException("Parameter subscriptionId is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (resourceProvider == null) {
            throw new IllegalArgumentException("Parameter resourceProvider is required and cannot be null.");
        }
        if (resourceTypeName == null) {
            throw new IllegalArgumentException("Parameter resourceTypeName is required and cannot be null.");
        }
        if (resourceName == null) {
            throw new IllegalArgumentException("Parameter resourceName is required and cannot be null.");
        }
        if (body == null) {
            throw new IllegalArgumentException("Parameter body is required and cannot be null.");
        }
        Validator.validate(body);
        final String contentType = null;
        final Integer contentLength = null;
        return service.azureMonitorCustomMetricsIngestionApi(subscriptionId, resourceGroupName, resourceProvider, resourceTypeName, resourceName, contentType, contentLength, body, this.acceptLanguage(), this.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<MicrosoftAspNetCoreMvcObjectResultInner>>>() {
                @Override
                public Observable<ServiceResponse<MicrosoftAspNetCoreMvcObjectResultInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<MicrosoftAspNetCoreMvcObjectResultInner> clientResponse = azureMonitorCustomMetricsIngestionApiDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * Ingestion API used by Azure custom metrics
                 Responsible of below operation
                 1. Authorize the request
                 2. Deserialize payload request body
                 3. Perform validation of the payload
                 4. Commits the payload for metrics ingestion.
     *
     * @param subscriptionId The azure subscription id
     * @param resourceGroupName The ARM resource group name
     * @param resourceProvider The ARM resource provider name
     * @param resourceTypeName The ARM resource type name
     * @param resourceName The ARM resource name
     * @param body The Azure metrics document json payload
     * @param contentType Supports application/json and application/x-ndjson
     * @param contentLength Content length of the payload
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws MicrosoftAspNetCoreMvcObjectResultInnerException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the MicrosoftAspNetCoreMvcObjectResultInner object if successful.
     */
    public MicrosoftAspNetCoreMvcObjectResultInner azureMonitorCustomMetricsIngestionApi(String subscriptionId, String resourceGroupName, String resourceProvider, String resourceTypeName, String resourceName, AzureMetricsDocument body, String contentType, Integer contentLength) {
        return azureMonitorCustomMetricsIngestionApiWithServiceResponseAsync(subscriptionId, resourceGroupName, resourceProvider, resourceTypeName, resourceName, body, contentType, contentLength).toBlocking().single().body();
    }

    /**
     * Ingestion API used by Azure custom metrics
                 Responsible of below operation
                 1. Authorize the request
                 2. Deserialize payload request body
                 3. Perform validation of the payload
                 4. Commits the payload for metrics ingestion.
     *
     * @param subscriptionId The azure subscription id
     * @param resourceGroupName The ARM resource group name
     * @param resourceProvider The ARM resource provider name
     * @param resourceTypeName The ARM resource type name
     * @param resourceName The ARM resource name
     * @param body The Azure metrics document json payload
     * @param contentType Supports application/json and application/x-ndjson
     * @param contentLength Content length of the payload
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<MicrosoftAspNetCoreMvcObjectResultInner> azureMonitorCustomMetricsIngestionApiAsync(String subscriptionId, String resourceGroupName, String resourceProvider, String resourceTypeName, String resourceName, AzureMetricsDocument body, String contentType, Integer contentLength, final ServiceCallback<MicrosoftAspNetCoreMvcObjectResultInner> serviceCallback) {
        return ServiceFuture.fromResponse(azureMonitorCustomMetricsIngestionApiWithServiceResponseAsync(subscriptionId, resourceGroupName, resourceProvider, resourceTypeName, resourceName, body, contentType, contentLength), serviceCallback);
    }

    /**
     * Ingestion API used by Azure custom metrics
                 Responsible of below operation
                 1. Authorize the request
                 2. Deserialize payload request body
                 3. Perform validation of the payload
                 4. Commits the payload for metrics ingestion.
     *
     * @param subscriptionId The azure subscription id
     * @param resourceGroupName The ARM resource group name
     * @param resourceProvider The ARM resource provider name
     * @param resourceTypeName The ARM resource type name
     * @param resourceName The ARM resource name
     * @param body The Azure metrics document json payload
     * @param contentType Supports application/json and application/x-ndjson
     * @param contentLength Content length of the payload
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the MicrosoftAspNetCoreMvcObjectResultInner object
     */
    public Observable<MicrosoftAspNetCoreMvcObjectResultInner> azureMonitorCustomMetricsIngestionApiAsync(String subscriptionId, String resourceGroupName, String resourceProvider, String resourceTypeName, String resourceName, AzureMetricsDocument body, String contentType, Integer contentLength) {
        return azureMonitorCustomMetricsIngestionApiWithServiceResponseAsync(subscriptionId, resourceGroupName, resourceProvider, resourceTypeName, resourceName, body, contentType, contentLength).map(new Func1<ServiceResponse<MicrosoftAspNetCoreMvcObjectResultInner>, MicrosoftAspNetCoreMvcObjectResultInner>() {
            @Override
            public MicrosoftAspNetCoreMvcObjectResultInner call(ServiceResponse<MicrosoftAspNetCoreMvcObjectResultInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Ingestion API used by Azure custom metrics
                 Responsible of below operation
                 1. Authorize the request
                 2. Deserialize payload request body
                 3. Perform validation of the payload
                 4. Commits the payload for metrics ingestion.
     *
     * @param subscriptionId The azure subscription id
     * @param resourceGroupName The ARM resource group name
     * @param resourceProvider The ARM resource provider name
     * @param resourceTypeName The ARM resource type name
     * @param resourceName The ARM resource name
     * @param body The Azure metrics document json payload
     * @param contentType Supports application/json and application/x-ndjson
     * @param contentLength Content length of the payload
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the MicrosoftAspNetCoreMvcObjectResultInner object
     */
    public Observable<ServiceResponse<MicrosoftAspNetCoreMvcObjectResultInner>> azureMonitorCustomMetricsIngestionApiWithServiceResponseAsync(String subscriptionId, String resourceGroupName, String resourceProvider, String resourceTypeName, String resourceName, AzureMetricsDocument body, String contentType, Integer contentLength) {
        if (subscriptionId == null) {
            throw new IllegalArgumentException("Parameter subscriptionId is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (resourceProvider == null) {
            throw new IllegalArgumentException("Parameter resourceProvider is required and cannot be null.");
        }
        if (resourceTypeName == null) {
            throw new IllegalArgumentException("Parameter resourceTypeName is required and cannot be null.");
        }
        if (resourceName == null) {
            throw new IllegalArgumentException("Parameter resourceName is required and cannot be null.");
        }
        if (body == null) {
            throw new IllegalArgumentException("Parameter body is required and cannot be null.");
        }
        Validator.validate(body);
        return service.azureMonitorCustomMetricsIngestionApi(subscriptionId, resourceGroupName, resourceProvider, resourceTypeName, resourceName, contentType, contentLength, body, this.acceptLanguage(), this.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<MicrosoftAspNetCoreMvcObjectResultInner>>>() {
                @Override
                public Observable<ServiceResponse<MicrosoftAspNetCoreMvcObjectResultInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<MicrosoftAspNetCoreMvcObjectResultInner> clientResponse = azureMonitorCustomMetricsIngestionApiDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<MicrosoftAspNetCoreMvcObjectResultInner> azureMonitorCustomMetricsIngestionApiDelegate(Response<ResponseBody> response) throws MicrosoftAspNetCoreMvcObjectResultInnerException, IOException, IllegalArgumentException {
        return this.restClient().responseBuilderFactory().<MicrosoftAspNetCoreMvcObjectResultInner, MicrosoftAspNetCoreMvcObjectResultInnerException>newInstance(this.serializerAdapter())
                .register(200, new TypeToken<MicrosoftAspNetCoreMvcObjectResultInner>() { }.getType())
                .registerError(MicrosoftAspNetCoreMvcObjectResultInnerException.class)
                .build(response);
    }

}
