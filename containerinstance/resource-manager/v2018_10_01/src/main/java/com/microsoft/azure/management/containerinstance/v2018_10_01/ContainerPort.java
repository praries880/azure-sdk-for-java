/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.containerinstance.v2018_10_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The port exposed on the container instance.
 */
public class ContainerPort {
    /**
     * The protocol associated with the port. Possible values include: 'TCP',
     * 'UDP'.
     */
    @JsonProperty(value = "protocol")
    private ContainerNetworkProtocol protocol;

    /**
     * The port number exposed within the container group.
     */
    @JsonProperty(value = "port", required = true)
    private int port;

    /**
     * Get the protocol associated with the port. Possible values include: 'TCP', 'UDP'.
     *
     * @return the protocol value
     */
    public ContainerNetworkProtocol protocol() {
        return this.protocol;
    }

    /**
     * Set the protocol associated with the port. Possible values include: 'TCP', 'UDP'.
     *
     * @param protocol the protocol value to set
     * @return the ContainerPort object itself.
     */
    public ContainerPort withProtocol(ContainerNetworkProtocol protocol) {
        this.protocol = protocol;
        return this;
    }

    /**
     * Get the port number exposed within the container group.
     *
     * @return the port value
     */
    public int port() {
        return this.port;
    }

    /**
     * Set the port number exposed within the container group.
     *
     * @param port the port value to set
     * @return the ContainerPort object itself.
     */
    public ContainerPort withPort(int port) {
        this.port = port;
        return this;
    }

}
