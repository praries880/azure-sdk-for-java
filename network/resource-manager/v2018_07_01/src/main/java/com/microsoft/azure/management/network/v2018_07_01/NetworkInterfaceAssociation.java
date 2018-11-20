/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2018_07_01;

import java.util.List;
import com.microsoft.azure.management.network.v2018_07_01.implementation.SecurityRuleInner;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Network interface and its custom security rules.
 */
public class NetworkInterfaceAssociation {
    /**
     * Network interface ID.
     */
    @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    /**
     * Collection of custom security rules.
     */
    @JsonProperty(value = "securityRules")
    private List<SecurityRuleInner> securityRules;

    /**
     * Get network interface ID.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Get collection of custom security rules.
     *
     * @return the securityRules value
     */
    public List<SecurityRuleInner> securityRules() {
        return this.securityRules;
    }

    /**
     * Set collection of custom security rules.
     *
     * @param securityRules the securityRules value to set
     * @return the NetworkInterfaceAssociation object itself.
     */
    public NetworkInterfaceAssociation withSecurityRules(List<SecurityRuleInner> securityRules) {
        this.securityRules = securityRules;
        return this;
    }

}
