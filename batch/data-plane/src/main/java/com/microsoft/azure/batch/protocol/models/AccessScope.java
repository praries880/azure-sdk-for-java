// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator

package com.microsoft.azure.batch.protocol.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for AccessScope.
 */
public enum AccessScope {
    /** Grants access to perform all operations on the job containing the task. */
    JOB("job");

    /** The actual serialized value for a AccessScope instance. */
    private String value;

    AccessScope(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a AccessScope instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed AccessScope object, or null if unable to parse.
     */
    @JsonCreator
    public static AccessScope fromString(String value) {
        AccessScope[] items = AccessScope.values();
        for (AccessScope item : items) {
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