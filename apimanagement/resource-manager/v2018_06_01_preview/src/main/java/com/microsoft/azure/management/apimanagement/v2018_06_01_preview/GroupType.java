/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.v2018_06_01_preview;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for GroupType.
 */
public enum GroupType {
    /** Enum value custom. */
    CUSTOM("custom"),

    /** Enum value system. */
    SYSTEM("system"),

    /** Enum value external. */
    EXTERNAL("external");

    /** The actual serialized value for a GroupType instance. */
    private String value;

    GroupType(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a GroupType instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed GroupType object, or null if unable to parse.
     */
    @JsonCreator
    public static GroupType fromString(String value) {
        GroupType[] items = GroupType.values();
        for (GroupType item : items) {
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
