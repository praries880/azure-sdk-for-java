/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.v2018_06_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Quota counter value details.
 */
public class QuotaCounterValueContractProperties {
    /**
     * Number of times Counter was called.
     */
    @JsonProperty(value = "callsCount")
    private Integer callsCount;

    /**
     * Data Transferred in KiloBytes.
     */
    @JsonProperty(value = "kbTransferred")
    private Double kbTransferred;

    /**
     * Get number of times Counter was called.
     *
     * @return the callsCount value
     */
    public Integer callsCount() {
        return this.callsCount;
    }

    /**
     * Set number of times Counter was called.
     *
     * @param callsCount the callsCount value to set
     * @return the QuotaCounterValueContractProperties object itself.
     */
    public QuotaCounterValueContractProperties withCallsCount(Integer callsCount) {
        this.callsCount = callsCount;
        return this;
    }

    /**
     * Get data Transferred in KiloBytes.
     *
     * @return the kbTransferred value
     */
    public Double kbTransferred() {
        return this.kbTransferred;
    }

    /**
     * Set data Transferred in KiloBytes.
     *
     * @param kbTransferred the kbTransferred value to set
     * @return the QuotaCounterValueContractProperties object itself.
     */
    public QuotaCounterValueContractProperties withKbTransferred(Double kbTransferred) {
        this.kbTransferred = kbTransferred;
        return this;
    }

}
