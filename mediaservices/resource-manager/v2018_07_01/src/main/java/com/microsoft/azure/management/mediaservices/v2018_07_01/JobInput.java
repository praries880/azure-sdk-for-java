/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mediaservices.v2018_07_01;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * Base class for inputs to a Job.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata.type")
@JsonTypeName("JobInput")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "#Microsoft.Media.JobInputClip", value = JobInputClip.class),
    @JsonSubTypes.Type(name = "#Microsoft.Media.JobInputs", value = JobInputs.class)
})
public class JobInput {
}
