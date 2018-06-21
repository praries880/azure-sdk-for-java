/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mediaservices.v2018_30_30_preview;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Represents an Asset used as a JobOutput.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata.type")
@JsonTypeName("#Microsoft.Media.JobOutputAsset")
public class JobOutputAsset extends JobOutput {
    /**
     * The name of the output Asset.
     */
    @JsonProperty(value = "assetName", required = true)
    private String assetName;

    /**
     * Get the name of the output Asset.
     *
     * @return the assetName value
     */
    public String assetName() {
        return this.assetName;
    }

    /**
     * Set the name of the output Asset.
     *
     * @param assetName the assetName value to set
     * @return the JobOutputAsset object itself.
     */
    public JobOutputAsset withAssetName(String assetName) {
        this.assetName = assetName;
        return this;
    }

}
