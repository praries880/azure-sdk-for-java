/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.dataplane.monitor;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The SystemIntPtr model.
 */
public class SystemIntPtr {
    /**
     * The size property.
     */
    @JsonProperty(value = "Size")
    private Integer size;

    /**
     * Get the size value.
     *
     * @return the size value
     */
    public Integer size() {
        return this.size;
    }

    /**
     * Set the size value.
     *
     * @param size the size value to set
     * @return the SystemIntPtr object itself.
     */
    public SystemIntPtr withSize(Integer size) {
        this.size = size;
        return this;
    }

}
