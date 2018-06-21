/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mediaservices.v2018_30_30_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to specify configurations of FairPlay in Streaming Policy.
 */
public class StreamingPolicyFairPlayConfiguration {
    /**
     * The template for a customer service to deliver keys to end users.  Not
     * needed when using Azure Media Services for issuing keys.
     */
    @JsonProperty(value = "customLicenseAcquisitionUrlTemplate")
    private String customLicenseAcquisitionUrlTemplate;

    /**
     * All license to be persistent or not.
     */
    @JsonProperty(value = "allowPersistentLicense", required = true)
    private boolean allowPersistentLicense;

    /**
     * Get the template for a customer service to deliver keys to end users.  Not needed when using Azure Media Services for issuing keys.
     *
     * @return the customLicenseAcquisitionUrlTemplate value
     */
    public String customLicenseAcquisitionUrlTemplate() {
        return this.customLicenseAcquisitionUrlTemplate;
    }

    /**
     * Set the template for a customer service to deliver keys to end users.  Not needed when using Azure Media Services for issuing keys.
     *
     * @param customLicenseAcquisitionUrlTemplate the customLicenseAcquisitionUrlTemplate value to set
     * @return the StreamingPolicyFairPlayConfiguration object itself.
     */
    public StreamingPolicyFairPlayConfiguration withCustomLicenseAcquisitionUrlTemplate(String customLicenseAcquisitionUrlTemplate) {
        this.customLicenseAcquisitionUrlTemplate = customLicenseAcquisitionUrlTemplate;
        return this;
    }

    /**
     * Get all license to be persistent or not.
     *
     * @return the allowPersistentLicense value
     */
    public boolean allowPersistentLicense() {
        return this.allowPersistentLicense;
    }

    /**
     * Set all license to be persistent or not.
     *
     * @param allowPersistentLicense the allowPersistentLicense value to set
     * @return the StreamingPolicyFairPlayConfiguration object itself.
     */
    public StreamingPolicyFairPlayConfiguration withAllowPersistentLicense(boolean allowPersistentLicense) {
        this.allowPersistentLicense = allowPersistentLicense;
        return this;
    }

}
