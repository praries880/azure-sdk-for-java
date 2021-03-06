// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.blob;

import com.azure.core.credentials.TokenCredential;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.policy.AddDatePolicy;
import com.azure.core.http.policy.BearerTokenAuthenticationPolicy;
import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLoggingPolicy;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.http.policy.RequestIdPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.implementation.util.ImplUtils;
import com.azure.core.util.configuration.Configuration;
import com.azure.core.util.configuration.ConfigurationManager;
import com.azure.storage.blob.implementation.AzureBlobStorageBuilder;
import com.azure.storage.common.credentials.SASTokenCredential;
import com.azure.storage.common.credentials.SharedKeyCredential;
import com.azure.storage.common.policy.RequestRetryOptions;
import com.azure.storage.common.policy.RequestRetryPolicy;
import com.azure.storage.common.policy.SASTokenCredentialPolicy;
import com.azure.storage.common.policy.SharedKeyCredentialPolicy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/**
 * Fluent BlockBlobClientBuilder for instantiating a {@link BlockBlobClient} or {@link BlockBlobAsyncClient}
 * using {@link BlockBlobClientBuilder#buildClient()} or {@link BlockBlobClientBuilder#buildAsyncClient()} respectively.
 *
 * <p>
 * The following information must be provided on this builder:
 *
 * <ul>
 *     <li>the endpoint through {@code .endpoint()}, including the container name and blob name, in the format of {@code https://{accountName}.blob.core.windows.net/{containerName}/{blobName}}.
 *     <li>the credential through {@code .credential()} or {@code .connectionString()} if the container is not publicly accessible.
 * </ul>
 *
 * <p>
 * Once all the configurations are set on this builder, call {@code .buildClient()} to create a
 * {@link BlockBlobClient} or {@code .buildAsyncClient()} to create a {@link BlockBlobAsyncClient}.
 */
public final class BlockBlobClientBuilder {
    private static final String ACCOUNT_NAME = "accountname";
    private static final String ACCOUNT_KEY = "accountkey";
    private static final String ENDPOINT_PROTOCOL = "defaultendpointsprotocol";
    private static final String ENDPOINT_SUFFIX = "endpointsuffix";

    private final List<HttpPipelinePolicy> policies;

    private String endpoint;
    private String containerName;
    private String blobName;
    private String snapshot;
    private SharedKeyCredential sharedKeyCredential;
    private TokenCredential tokenCredential;
    private SASTokenCredential sasTokenCredential;
    private HttpClient httpClient;
    private HttpLogDetailLevel logLevel;
    private RequestRetryOptions retryOptions;
    private Configuration configuration;

    /**
     * Creates a builder instance that is able to configure and construct {@link BlockBlobClient BlockBlobClients}
     * and {@link BlockBlobAsyncClient BlockBlobAsyncClients}.
     */
    public BlockBlobClientBuilder() {
        retryOptions = new RequestRetryOptions();
        logLevel = HttpLogDetailLevel.NONE;
        policies = new ArrayList<>();
    }

    /**
     * Constructs an instance of BlockBlobAsyncClient based on the configurations stored in the appendBlobClientBuilder.
     * @return a new client instance
     */
    private AzureBlobStorageBuilder buildImpl() {
        Objects.requireNonNull(endpoint);
        Objects.requireNonNull(containerName);
        Objects.requireNonNull(blobName);

        // Closest to API goes first, closest to wire goes last.
        final List<HttpPipelinePolicy> policies = new ArrayList<>();

        if (configuration == null) {
            configuration = ConfigurationManager.getConfiguration();
        }
        policies.add(new UserAgentPolicy(BlobConfiguration.NAME, BlobConfiguration.VERSION, configuration));
        policies.add(new RequestIdPolicy());
        policies.add(new AddDatePolicy());

        if (sharedKeyCredential != null) {
            policies.add(new SharedKeyCredentialPolicy(sharedKeyCredential));
        } else if (tokenCredential != null) {
            policies.add(new BearerTokenAuthenticationPolicy(tokenCredential, String.format("%s/.default", endpoint)));
        } else if (sasTokenCredential != null) {
            policies.add(new SASTokenCredentialPolicy(sasTokenCredential));
        } else {
            policies.add(new AnonymousCredentialPolicy());
        }

        policies.add(new RequestRetryPolicy(retryOptions));

        policies.addAll(this.policies);
        policies.add(new HttpLoggingPolicy(logLevel));

        HttpPipeline pipeline = HttpPipeline.builder()
            .policies(policies.toArray(new HttpPipelinePolicy[0]))
            .httpClient(httpClient)
            .build();

        return new AzureBlobStorageBuilder()
            .url(String.format("%s/%s/%s", endpoint, containerName, blobName))
            .pipeline(pipeline);
    }

    /**
     * @return a {@link BlockBlobClient} created from the configurations in this builder.
     */
    public BlockBlobClient buildClient() {
        return new BlockBlobClient(buildAsyncClient());
    }

    /**
     * @return a {@link BlockBlobAsyncClient} created from the configurations in this builder.
     */
    public BlockBlobAsyncClient buildAsyncClient() {
        return new BlockBlobAsyncClient(buildImpl(), snapshot);
    }

    /**
     * Sets the service endpoint, additionally parses it for information (SAS token, container name, blob name)
     * @param endpoint URL of the service
     * @return the updated BlockBlobClientBuilder object
     * @throws IllegalArgumentException If {@code endpoint} is a malformed URL.
     */
    public BlockBlobClientBuilder endpoint(String endpoint) {
        Objects.requireNonNull(endpoint);
        URL url;
        try {
            url = new URL(endpoint);
            BlobURLParts parts = URLParser.parse(url);
            this.endpoint = parts.scheme() + "://" + parts.host();

            if (parts.containerName() != null) {
                this.containerName = parts.containerName();
            }

            if (parts.blobName() != null) {
                this.blobName = parts.blobName();
            }

            if (parts.snapshot() != null) {
                this.snapshot = parts.snapshot();
            }
        } catch (MalformedURLException ex) {
            throw new IllegalArgumentException("The Azure Storage Blob endpoint url is malformed.");
        }

        SASTokenCredential credential = SASTokenCredential.fromQuery(url.getQuery());
        if (credential != null) {
            this.credential(credential);
        }

        return this;
    }

    /**
     * Sets the name of the container this client is connecting to.
     * @param containerName the name of the container
     * @return the updated BlockBlobClientBuilder object
     */
    public BlockBlobClientBuilder containerName(String containerName) {
        this.containerName = containerName;
        return this;
    }

    /**
     * Sets the name of the blob this client is connecting to.
     * @param blobName the name of the blob
     * @return the updated BlockBlobClientBuilder object
     */
    public BlockBlobClientBuilder blobName(String blobName) {
        this.blobName = blobName;
        return this;
    }

    /**
     * Sets the snapshot of the blob this client is connecting to.
     * @param snapshot the snapshot identifier for the blob
     * @return the updated BlockBlobClientBuilder object
     */
    public BlockBlobClientBuilder snapshot(String snapshot) {
        this.snapshot = snapshot;
        return this;
    }

    /**
     * Sets the credential used to authorize requests sent to the service
     * @param credential authorization credential
     * @return the updated BlockBlobClientBuilder object
     */
    public BlockBlobClientBuilder credential(SharedKeyCredential credential) {
        this.sharedKeyCredential = credential;
        this.tokenCredential = null;
        this.sasTokenCredential = null;
        return this;
    }

    /**
     * Sets the credential used to authorize requests sent to the service
     * @param credential authorization credential
     * @return the updated BlockBlobClientBuilder object
     */
    public BlockBlobClientBuilder credential(TokenCredential credential) {
        this.tokenCredential = credential;
        this.sharedKeyCredential = null;
        this.sasTokenCredential = null;
        return this;
    }

    /**
     * Sets the credential used to authorize requests sent to the service
     * @param credential authorization credential
     * @return the updated BlockBlobClientBuilder object
     */
    public BlockBlobClientBuilder credential(SASTokenCredential credential) {
        this.sasTokenCredential = credential;
        this.sharedKeyCredential = null;
        this.tokenCredential = null;
        return this;
    }

    /**
     * Clears the credential used to authorize requests sent to the service
     * @return the updated BlockBlobClientBuilder object
     */
    public BlockBlobClientBuilder anonymousCredential() {
        this.sharedKeyCredential = null;
        this.tokenCredential = null;
        this.sasTokenCredential = null;
        return this;
    }

    /**
     * Sets the connection string for the service, parses it for authentication information (account name, account key)
     * @param connectionString connection string from access keys section
     * @return the updated BlockBlobClientBuilder object
     * @throws IllegalArgumentException If {@code connectionString} doesn't contain AccountName or AccountKey
     */
    public BlockBlobClientBuilder connectionString(String connectionString) {
        Objects.requireNonNull(connectionString);

        Map<String, String> connectionKVPs = new HashMap<>();
        for (String s : connectionString.split(";")) {
            String[] kvp = s.split("=", 2);
            connectionKVPs.put(kvp[0].toLowerCase(Locale.ROOT), kvp[1]);
        }

        String accountName = connectionKVPs.get(ACCOUNT_NAME);
        String accountKey = connectionKVPs.get(ACCOUNT_KEY);
        String endpointProtocol = connectionKVPs.get(ENDPOINT_PROTOCOL);
        String endpointSuffix = connectionKVPs.get(ENDPOINT_SUFFIX);

        if (ImplUtils.isNullOrEmpty(accountName) || ImplUtils.isNullOrEmpty(accountKey)) {
            throw new IllegalArgumentException("Connection string must contain 'AccountName' and 'AccountKey'.");
        }

        if (!ImplUtils.isNullOrEmpty(endpointProtocol) && !ImplUtils.isNullOrEmpty(endpointSuffix)) {
            String endpoint = String.format("%s://%s.blob.%s", endpointProtocol, accountName, endpointSuffix.replaceFirst("^\\.", ""));
            endpoint(endpoint);
        }

        // Use accountName and accountKey to get the SAS token using the credential class.
        return credential(new SharedKeyCredential(accountName, accountKey));
    }

    /**
     * Sets the http client used to send service requests
     * @param httpClient http client to send requests
     * @return the updated BlockBlobClientBuilder object
     */
    public BlockBlobClientBuilder httpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    /**
     * Adds a pipeline policy to apply on each request sent
     * @param pipelinePolicy a pipeline policy
     * @return the updated BlockBlobClientBuilder object
     */
    public BlockBlobClientBuilder addPolicy(HttpPipelinePolicy pipelinePolicy) {
        this.policies.add(pipelinePolicy);
        return this;
    }

    /**
     * Sets the logging level for service requests
     * @param logLevel logging level
     * @return the updated BlockBlobClientBuilder object
     */
    public BlockBlobClientBuilder httpLogDetailLevel(HttpLogDetailLevel logLevel) {
        this.logLevel = logLevel;
        return this;
    }

    /**
     * Sets the configuration object used to retrieve environment configuration values used to buildClient the client with
     * when they are not set in the appendBlobClientBuilder, defaults to Configuration.NONE
     * @param configuration configuration store
     * @return the updated BlockBlobClientBuilder object
     */
    public BlockBlobClientBuilder configuration(Configuration configuration) {
        this.configuration = configuration;
        return this;
    }

    /**
     * Sets the request retry options for all the requests made through the client.
     * @param retryOptions the options to configure retry behaviors
     * @return the updated BlockBlobClientBuilder object
     */
    public BlockBlobClientBuilder retryOptions(RequestRetryOptions retryOptions) {
        this.retryOptions = retryOptions;
        return this;
    }
}
