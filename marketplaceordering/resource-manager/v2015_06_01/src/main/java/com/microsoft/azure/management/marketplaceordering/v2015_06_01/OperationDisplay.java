/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.marketplaceordering.v2015_06_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The object that represents the operation.
 */
public class OperationDisplay {
    /**
     * Service provider: Microsoft.MarketplaceOrdering.
     */
    @JsonProperty(value = "provider")
    private String provider;

    /**
     * Resource on which the operation is performed: Agreement, virtualmachine,
     * etc.
     */
    @JsonProperty(value = "resource")
    private String resource;

    /**
     * Operation type: Get Agreement, Sign Agreement, Cancel Agreement etc.
     */
    @JsonProperty(value = "operation")
    private String operation;

    /**
     * Get service provider: Microsoft.MarketplaceOrdering.
     *
     * @return the provider value
     */
    public String provider() {
        return this.provider;
    }

    /**
     * Set service provider: Microsoft.MarketplaceOrdering.
     *
     * @param provider the provider value to set
     * @return the OperationDisplay object itself.
     */
    public OperationDisplay withProvider(String provider) {
        this.provider = provider;
        return this;
    }

    /**
     * Get resource on which the operation is performed: Agreement, virtualmachine, etc.
     *
     * @return the resource value
     */
    public String resource() {
        return this.resource;
    }

    /**
     * Set resource on which the operation is performed: Agreement, virtualmachine, etc.
     *
     * @param resource the resource value to set
     * @return the OperationDisplay object itself.
     */
    public OperationDisplay withResource(String resource) {
        this.resource = resource;
        return this;
    }

    /**
     * Get operation type: Get Agreement, Sign Agreement, Cancel Agreement etc.
     *
     * @return the operation value
     */
    public String operation() {
        return this.operation;
    }

    /**
     * Set operation type: Get Agreement, Sign Agreement, Cancel Agreement etc.
     *
     * @param operation the operation value to set
     * @return the OperationDisplay object itself.
     */
    public OperationDisplay withOperation(String operation) {
        this.operation = operation;
        return this;
    }

}
