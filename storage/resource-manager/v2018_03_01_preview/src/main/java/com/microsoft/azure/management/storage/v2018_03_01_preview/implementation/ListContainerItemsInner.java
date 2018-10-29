/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.storage.v2018_03_01_preview.implementation;

import java.util.List;
import com.microsoft.azure.management.storage.v2018_03_01_preview.ListContainerItem;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The list of blob containers.
 */
public class ListContainerItemsInner {
    /**
     * The list of blob containers.
     */
    @JsonProperty(value = "value")
    private List<ListContainerItem> value;

    /**
     * Get the list of blob containers.
     *
     * @return the value value
     */
    public List<ListContainerItem> value() {
        return this.value;
    }

    /**
     * Set the list of blob containers.
     *
     * @param value the value value to set
     * @return the ListContainerItemsInner object itself.
     */
    public ListContainerItemsInner withValue(List<ListContainerItem> value) {
        this.value = value;
        return this;
    }

}
