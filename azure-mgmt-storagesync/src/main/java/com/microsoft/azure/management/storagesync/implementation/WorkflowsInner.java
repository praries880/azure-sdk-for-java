/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.storagesync.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.management.storagesync.StorageSyncErrorException;
import com.microsoft.azure.management.storagesync.WorkflowsAbortHeaders;
import com.microsoft.azure.management.storagesync.WorkflowsGetHeaders;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponseWithHeaders;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in Workflows.
 */
public class WorkflowsInner {
    /** The Retrofit service to perform REST calls. */
    private WorkflowsService service;
    /** The service client containing this operation class. */
    private StorageSyncManagementClientImpl client;

    /**
     * Initializes an instance of WorkflowsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public WorkflowsInner(Retrofit retrofit, StorageSyncManagementClientImpl client) {
        this.service = retrofit.create(WorkflowsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for Workflows to be
     * used by Retrofit to perform actually REST calls.
     */
    interface WorkflowsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.storagesync.Workflows get" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.StorageSync/storageSyncServices/{storageSyncServiceName}/workflows/{workflowId}")
        Observable<Response<ResponseBody>> get(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("storageSyncServiceName") String storageSyncServiceName, @Path("workflowId") String workflowId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.storagesync.Workflows abort" })
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.StorageSync/storageSyncServices/{storageSyncServiceName}/workflows/{workflowId}/abort")
        Observable<Response<ResponseBody>> abort(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("storageSyncServiceName") String storageSyncServiceName, @Path("workflowId") String workflowId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Get Workflows resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param storageSyncServiceName Name of Storage Sync Service resource.
     * @param workflowId workflow Id
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws StorageSyncErrorException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the WorkflowInner object if successful.
     */
    public WorkflowInner get(String resourceGroupName, String storageSyncServiceName, String workflowId) {
        return getWithServiceResponseAsync(resourceGroupName, storageSyncServiceName, workflowId).toBlocking().single().body();
    }

    /**
     * Get Workflows resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param storageSyncServiceName Name of Storage Sync Service resource.
     * @param workflowId workflow Id
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<WorkflowInner> getAsync(String resourceGroupName, String storageSyncServiceName, String workflowId, final ServiceCallback<WorkflowInner> serviceCallback) {
        return ServiceFuture.fromHeaderResponse(getWithServiceResponseAsync(resourceGroupName, storageSyncServiceName, workflowId), serviceCallback);
    }

    /**
     * Get Workflows resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param storageSyncServiceName Name of Storage Sync Service resource.
     * @param workflowId workflow Id
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the WorkflowInner object
     */
    public Observable<WorkflowInner> getAsync(String resourceGroupName, String storageSyncServiceName, String workflowId) {
        return getWithServiceResponseAsync(resourceGroupName, storageSyncServiceName, workflowId).map(new Func1<ServiceResponseWithHeaders<WorkflowInner, WorkflowsGetHeaders>, WorkflowInner>() {
            @Override
            public WorkflowInner call(ServiceResponseWithHeaders<WorkflowInner, WorkflowsGetHeaders> response) {
                return response.body();
            }
        });
    }

    /**
     * Get Workflows resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param storageSyncServiceName Name of Storage Sync Service resource.
     * @param workflowId workflow Id
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the WorkflowInner object
     */
    public Observable<ServiceResponseWithHeaders<WorkflowInner, WorkflowsGetHeaders>> getWithServiceResponseAsync(String resourceGroupName, String storageSyncServiceName, String workflowId) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (storageSyncServiceName == null) {
            throw new IllegalArgumentException("Parameter storageSyncServiceName is required and cannot be null.");
        }
        if (workflowId == null) {
            throw new IllegalArgumentException("Parameter workflowId is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.get(this.client.subscriptionId(), resourceGroupName, storageSyncServiceName, workflowId, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponseWithHeaders<WorkflowInner, WorkflowsGetHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<WorkflowInner, WorkflowsGetHeaders>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponseWithHeaders<WorkflowInner, WorkflowsGetHeaders> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponseWithHeaders<WorkflowInner, WorkflowsGetHeaders> getDelegate(Response<ResponseBody> response) throws StorageSyncErrorException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<WorkflowInner, StorageSyncErrorException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<WorkflowInner>() { }.getType())
                .registerError(StorageSyncErrorException.class)
                .buildWithHeaders(response, WorkflowsGetHeaders.class);
    }

    /**
     * Abort the given workflow.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param storageSyncServiceName Name of Storage Sync Service resource.
     * @param workflowId workflow Id
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws StorageSyncErrorException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    public void abort(String resourceGroupName, String storageSyncServiceName, String workflowId) {
        abortWithServiceResponseAsync(resourceGroupName, storageSyncServiceName, workflowId).toBlocking().single().body();
    }

    /**
     * Abort the given workflow.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param storageSyncServiceName Name of Storage Sync Service resource.
     * @param workflowId workflow Id
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Void> abortAsync(String resourceGroupName, String storageSyncServiceName, String workflowId, final ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromHeaderResponse(abortWithServiceResponseAsync(resourceGroupName, storageSyncServiceName, workflowId), serviceCallback);
    }

    /**
     * Abort the given workflow.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param storageSyncServiceName Name of Storage Sync Service resource.
     * @param workflowId workflow Id
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public Observable<Void> abortAsync(String resourceGroupName, String storageSyncServiceName, String workflowId) {
        return abortWithServiceResponseAsync(resourceGroupName, storageSyncServiceName, workflowId).map(new Func1<ServiceResponseWithHeaders<Void, WorkflowsAbortHeaders>, Void>() {
            @Override
            public Void call(ServiceResponseWithHeaders<Void, WorkflowsAbortHeaders> response) {
                return response.body();
            }
        });
    }

    /**
     * Abort the given workflow.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param storageSyncServiceName Name of Storage Sync Service resource.
     * @param workflowId workflow Id
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public Observable<ServiceResponseWithHeaders<Void, WorkflowsAbortHeaders>> abortWithServiceResponseAsync(String resourceGroupName, String storageSyncServiceName, String workflowId) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (storageSyncServiceName == null) {
            throw new IllegalArgumentException("Parameter storageSyncServiceName is required and cannot be null.");
        }
        if (workflowId == null) {
            throw new IllegalArgumentException("Parameter workflowId is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.abort(this.client.subscriptionId(), resourceGroupName, storageSyncServiceName, workflowId, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponseWithHeaders<Void, WorkflowsAbortHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Void, WorkflowsAbortHeaders>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponseWithHeaders<Void, WorkflowsAbortHeaders> clientResponse = abortDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponseWithHeaders<Void, WorkflowsAbortHeaders> abortDelegate(Response<ResponseBody> response) throws StorageSyncErrorException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<Void, StorageSyncErrorException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<Void>() { }.getType())
                .registerError(StorageSyncErrorException.class)
                .buildWithHeaders(response, WorkflowsAbortHeaders.class);
    }

}
