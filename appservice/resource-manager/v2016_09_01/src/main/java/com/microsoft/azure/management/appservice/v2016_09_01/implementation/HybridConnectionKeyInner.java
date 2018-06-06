/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.v2016_09_01.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.management.appservice.v2016_09_01.ProxyOnlyResource;

/**
 * Hybrid Connection key contract. This has the send key name and value for a
 * Hybrid Connection.
 */
@JsonFlatten
public class HybridConnectionKeyInner extends ProxyOnlyResource {
    /**
     * The name of the send key.
     */
    @JsonProperty(value = "properties.sendKeyName", access = JsonProperty.Access.WRITE_ONLY)
    private String sendKeyName;

    /**
     * The value of the send key.
     */
    @JsonProperty(value = "properties.sendKeyValue", access = JsonProperty.Access.WRITE_ONLY)
    private String sendKeyValue;

    /**
     * Get the sendKeyName value.
     *
     * @return the sendKeyName value
     */
    public String sendKeyName() {
        return this.sendKeyName;
    }

    /**
     * Get the sendKeyValue value.
     *
     * @return the sendKeyValue value
     */
    public String sendKeyValue() {
        return this.sendKeyValue;
    }

}