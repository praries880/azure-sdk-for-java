/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.recoveryservices.siterecovery.v2018_01_10;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class contains the error details per object.
 */
public class ProviderError {
    /**
     * The Error code.
     */
    @JsonProperty(value = "errorCode")
    private Integer errorCode;

    /**
     * The Error message.
     */
    @JsonProperty(value = "errorMessage")
    private String errorMessage;

    /**
     * The Provider error Id.
     */
    @JsonProperty(value = "errorId")
    private String errorId;

    /**
     * The possible causes for the error.
     */
    @JsonProperty(value = "possibleCauses")
    private String possibleCauses;

    /**
     * The recommended action to resolve the error.
     */
    @JsonProperty(value = "recommendedAction")
    private String recommendedAction;

    /**
     * Get the Error code.
     *
     * @return the errorCode value
     */
    public Integer errorCode() {
        return this.errorCode;
    }

    /**
     * Set the Error code.
     *
     * @param errorCode the errorCode value to set
     * @return the ProviderError object itself.
     */
    public ProviderError withErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    /**
     * Get the Error message.
     *
     * @return the errorMessage value
     */
    public String errorMessage() {
        return this.errorMessage;
    }

    /**
     * Set the Error message.
     *
     * @param errorMessage the errorMessage value to set
     * @return the ProviderError object itself.
     */
    public ProviderError withErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    /**
     * Get the Provider error Id.
     *
     * @return the errorId value
     */
    public String errorId() {
        return this.errorId;
    }

    /**
     * Set the Provider error Id.
     *
     * @param errorId the errorId value to set
     * @return the ProviderError object itself.
     */
    public ProviderError withErrorId(String errorId) {
        this.errorId = errorId;
        return this;
    }

    /**
     * Get the possible causes for the error.
     *
     * @return the possibleCauses value
     */
    public String possibleCauses() {
        return this.possibleCauses;
    }

    /**
     * Set the possible causes for the error.
     *
     * @param possibleCauses the possibleCauses value to set
     * @return the ProviderError object itself.
     */
    public ProviderError withPossibleCauses(String possibleCauses) {
        this.possibleCauses = possibleCauses;
        return this;
    }

    /**
     * Get the recommended action to resolve the error.
     *
     * @return the recommendedAction value
     */
    public String recommendedAction() {
        return this.recommendedAction;
    }

    /**
     * Set the recommended action to resolve the error.
     *
     * @param recommendedAction the recommendedAction value to set
     * @return the ProviderError object itself.
     */
    public ProviderError withRecommendedAction(String recommendedAction) {
        this.recommendedAction = recommendedAction;
        return this;
    }

}
