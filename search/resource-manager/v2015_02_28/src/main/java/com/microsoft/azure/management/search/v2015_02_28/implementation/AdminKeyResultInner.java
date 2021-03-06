/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.search.v2015_02_28.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response containing the primary and secondary API keys for a given Azure
 * Search service.
 */
public class AdminKeyResultInner {
    /**
     * The primary API key of the Search service.
     */
    @JsonProperty(value = "primaryKey", access = JsonProperty.Access.WRITE_ONLY)
    private String primaryKey;

    /**
     * The secondary API key of the Search service.
     */
    @JsonProperty(value = "secondaryKey", access = JsonProperty.Access.WRITE_ONLY)
    private String secondaryKey;

    /**
     * Get the primary API key of the Search service.
     *
     * @return the primaryKey value
     */
    public String primaryKey() {
        return this.primaryKey;
    }

    /**
     * Get the secondary API key of the Search service.
     *
     * @return the secondaryKey value
     */
    public String secondaryKey() {
        return this.secondaryKey;
    }

}
