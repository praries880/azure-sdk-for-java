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
 * Defines values for AacAudioProfile.
 */
public enum AacAudioProfile {
    /** Specifies that the output audio is to be encoded into AAC Low Complexity profile (AAC-LC). */
    AAC_LC("AacLc"),

    /** Specifies that the output audio is to be encoded into HE-AAC v1 profile. */
    HE_AAC_V1("HeAacV1"),

    /** Specifies that the output audio is to be encoded into HE-AAC v2 profile. */
    HE_AAC_V2("HeAacV2");

    /** The actual serialized value for a AacAudioProfile instance. */
    private String value;

    AacAudioProfile(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a AacAudioProfile instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed AacAudioProfile object, or null if unable to parse.
     */
    @JsonCreator
    public static AacAudioProfile fromString(String value) {
        AacAudioProfile[] items = AacAudioProfile.values();
        for (AacAudioProfile item : items) {
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
