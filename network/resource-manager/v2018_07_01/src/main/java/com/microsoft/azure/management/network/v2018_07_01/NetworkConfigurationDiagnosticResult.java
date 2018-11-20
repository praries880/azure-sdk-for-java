/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2018_07_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Network configuration diagnostic result corresponded to provided traffic
 * query.
 */
public class NetworkConfigurationDiagnosticResult {
    /**
     * The trafficQuery property.
     */
    @JsonProperty(value = "trafficQuery")
    private TrafficQuery trafficQuery;

    /**
     * The networkSecurityGroupResult property.
     */
    @JsonProperty(value = "networkSecurityGroupResult")
    private NetworkSecurityGroupResult networkSecurityGroupResult;

    /**
     * Get the trafficQuery value.
     *
     * @return the trafficQuery value
     */
    public TrafficQuery trafficQuery() {
        return this.trafficQuery;
    }

    /**
     * Set the trafficQuery value.
     *
     * @param trafficQuery the trafficQuery value to set
     * @return the NetworkConfigurationDiagnosticResult object itself.
     */
    public NetworkConfigurationDiagnosticResult withTrafficQuery(TrafficQuery trafficQuery) {
        this.trafficQuery = trafficQuery;
        return this;
    }

    /**
     * Get the networkSecurityGroupResult value.
     *
     * @return the networkSecurityGroupResult value
     */
    public NetworkSecurityGroupResult networkSecurityGroupResult() {
        return this.networkSecurityGroupResult;
    }

    /**
     * Set the networkSecurityGroupResult value.
     *
     * @param networkSecurityGroupResult the networkSecurityGroupResult value to set
     * @return the NetworkConfigurationDiagnosticResult object itself.
     */
    public NetworkConfigurationDiagnosticResult withNetworkSecurityGroupResult(NetworkSecurityGroupResult networkSecurityGroupResult) {
        this.networkSecurityGroupResult = networkSecurityGroupResult;
        return this;
    }

}
