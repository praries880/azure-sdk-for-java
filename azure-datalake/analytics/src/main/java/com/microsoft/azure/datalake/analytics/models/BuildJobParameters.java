/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.datalake.analytics.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The parameters used to build a new Data Lake Analytics job.
 */
public class BuildJobParameters extends BaseJobParameters {
    /**
     * the friendly name of the job to build.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * Get the friendly name of the job to build.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the friendly name of the job to build.
     *
     * @param name the name value to set
     * @return the BuildJobParameters object itself.
     */
    public BuildJobParameters withName(String name) {
        this.name = name;
        return this;
    }

}
