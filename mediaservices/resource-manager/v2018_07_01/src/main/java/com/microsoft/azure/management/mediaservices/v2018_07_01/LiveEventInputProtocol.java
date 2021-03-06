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
 * Defines values for LiveEventInputProtocol.
 */
public enum LiveEventInputProtocol {
    /** Enum value FragmentedMP4. */
    FRAGMENTED_MP4("FragmentedMP4"),

    /** Enum value RTMP. */
    RTMP("RTMP");

    /** The actual serialized value for a LiveEventInputProtocol instance. */
    private String value;

    LiveEventInputProtocol(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a LiveEventInputProtocol instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed LiveEventInputProtocol object, or null if unable to parse.
     */
    @JsonCreator
    public static LiveEventInputProtocol fromString(String value) {
        LiveEventInputProtocol[] items = LiveEventInputProtocol.values();
        for (LiveEventInputProtocol item : items) {
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
