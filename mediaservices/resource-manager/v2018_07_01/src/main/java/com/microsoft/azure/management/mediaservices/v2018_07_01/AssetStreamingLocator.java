/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mediaservices.v2018_07_01;

import org.joda.time.DateTime;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Properties of the Streaming Locator.
 */
public class AssetStreamingLocator {
    /**
     * Streaming Locator name.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    /**
     * Asset Name.
     */
    @JsonProperty(value = "assetName", access = JsonProperty.Access.WRITE_ONLY)
    private String assetName;

    /**
     * The creation time of the Streaming Locator.
     */
    @JsonProperty(value = "created", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime created;

    /**
     * The start time of the Streaming Locator.
     */
    @JsonProperty(value = "startTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime startTime;

    /**
     * The end time of the Streaming Locator.
     */
    @JsonProperty(value = "endTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime endTime;

    /**
     * StreamingLocatorId of the Streaming Locator.
     */
    @JsonProperty(value = "streamingLocatorId", access = JsonProperty.Access.WRITE_ONLY)
    private UUID streamingLocatorId;

    /**
     * Name of the Streaming Policy used by this Streaming Locator.
     */
    @JsonProperty(value = "streamingPolicyName", access = JsonProperty.Access.WRITE_ONLY)
    private String streamingPolicyName;

    /**
     * Name of the default ContentKeyPolicy used by this Streaming Locator.
     */
    @JsonProperty(value = "defaultContentKeyPolicyName", access = JsonProperty.Access.WRITE_ONLY)
    private String defaultContentKeyPolicyName;

    /**
     * Get streaming Locator name.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Get asset Name.
     *
     * @return the assetName value
     */
    public String assetName() {
        return this.assetName;
    }

    /**
     * Get the creation time of the Streaming Locator.
     *
     * @return the created value
     */
    public DateTime created() {
        return this.created;
    }

    /**
     * Get the start time of the Streaming Locator.
     *
     * @return the startTime value
     */
    public DateTime startTime() {
        return this.startTime;
    }

    /**
     * Get the end time of the Streaming Locator.
     *
     * @return the endTime value
     */
    public DateTime endTime() {
        return this.endTime;
    }

    /**
     * Get streamingLocatorId of the Streaming Locator.
     *
     * @return the streamingLocatorId value
     */
    public UUID streamingLocatorId() {
        return this.streamingLocatorId;
    }

    /**
     * Get name of the Streaming Policy used by this Streaming Locator.
     *
     * @return the streamingPolicyName value
     */
    public String streamingPolicyName() {
        return this.streamingPolicyName;
    }

    /**
     * Get name of the default ContentKeyPolicy used by this Streaming Locator.
     *
     * @return the defaultContentKeyPolicyName value
     */
    public String defaultContentKeyPolicyName() {
        return this.defaultContentKeyPolicyName;
    }

}
