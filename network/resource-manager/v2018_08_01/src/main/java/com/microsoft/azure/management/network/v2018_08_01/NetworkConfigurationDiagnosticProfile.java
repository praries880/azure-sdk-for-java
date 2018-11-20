/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2018_08_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Parameters to compare with network configuration.
 */
public class NetworkConfigurationDiagnosticProfile {
    /**
     * The direction of the traffic. Accepted values are 'Inbound' and
     * 'Outbound'. Possible values include: 'Inbound', 'Outbound'.
     */
    @JsonProperty(value = "direction", required = true)
    private Direction direction;

    /**
     * Protocol to be verified on. Accepted values are '*', TCP, UDP.
     */
    @JsonProperty(value = "protocol", required = true)
    private String protocol;

    /**
     * Traffic source. Accepted values are '*', IP Address/CIDR, Service Tag.
     */
    @JsonProperty(value = "source", required = true)
    private String source;

    /**
     * Traffic destination. Accepted values are: '*', IP Address/CIDR, Service
     * Tag.
     */
    @JsonProperty(value = "destination", required = true)
    private String destination;

    /**
     * Traffice destination port. Accepted values are '*', port (for example,
     * 3389) and port range (for example, 80-100).
     */
    @JsonProperty(value = "destinationPort", required = true)
    private String destinationPort;

    /**
     * Get the direction of the traffic. Accepted values are 'Inbound' and 'Outbound'. Possible values include: 'Inbound', 'Outbound'.
     *
     * @return the direction value
     */
    public Direction direction() {
        return this.direction;
    }

    /**
     * Set the direction of the traffic. Accepted values are 'Inbound' and 'Outbound'. Possible values include: 'Inbound', 'Outbound'.
     *
     * @param direction the direction value to set
     * @return the NetworkConfigurationDiagnosticProfile object itself.
     */
    public NetworkConfigurationDiagnosticProfile withDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    /**
     * Get protocol to be verified on. Accepted values are '*', TCP, UDP.
     *
     * @return the protocol value
     */
    public String protocol() {
        return this.protocol;
    }

    /**
     * Set protocol to be verified on. Accepted values are '*', TCP, UDP.
     *
     * @param protocol the protocol value to set
     * @return the NetworkConfigurationDiagnosticProfile object itself.
     */
    public NetworkConfigurationDiagnosticProfile withProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    /**
     * Get traffic source. Accepted values are '*', IP Address/CIDR, Service Tag.
     *
     * @return the source value
     */
    public String source() {
        return this.source;
    }

    /**
     * Set traffic source. Accepted values are '*', IP Address/CIDR, Service Tag.
     *
     * @param source the source value to set
     * @return the NetworkConfigurationDiagnosticProfile object itself.
     */
    public NetworkConfigurationDiagnosticProfile withSource(String source) {
        this.source = source;
        return this;
    }

    /**
     * Get traffic destination. Accepted values are: '*', IP Address/CIDR, Service Tag.
     *
     * @return the destination value
     */
    public String destination() {
        return this.destination;
    }

    /**
     * Set traffic destination. Accepted values are: '*', IP Address/CIDR, Service Tag.
     *
     * @param destination the destination value to set
     * @return the NetworkConfigurationDiagnosticProfile object itself.
     */
    public NetworkConfigurationDiagnosticProfile withDestination(String destination) {
        this.destination = destination;
        return this;
    }

    /**
     * Get traffice destination port. Accepted values are '*', port (for example, 3389) and port range (for example, 80-100).
     *
     * @return the destinationPort value
     */
    public String destinationPort() {
        return this.destinationPort;
    }

    /**
     * Set traffice destination port. Accepted values are '*', port (for example, 3389) and port range (for example, 80-100).
     *
     * @param destinationPort the destinationPort value to set
     * @return the NetworkConfigurationDiagnosticProfile object itself.
     */
    public NetworkConfigurationDiagnosticProfile withDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort;
        return this;
    }

}
