/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mediaservices.v2018_07_01;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for MetricAggregationType.
 */
public enum MetricAggregationType {
    /** The average. */
    AVERAGE("Average"),

    /** The count of a number of items, usually requests. */
    COUNT("Count"),

    /** The sum. */
    TOTAL("Total");

    /** The actual serialized value for a MetricAggregationType instance. */
    private String value;

    MetricAggregationType(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a MetricAggregationType instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed MetricAggregationType object, or null if unable to parse.
     */
    @JsonCreator
    public static MetricAggregationType fromString(String value) {
        MetricAggregationType[] items = MetricAggregationType.values();
        for (MetricAggregationType item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
