/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalakestore.v2015_10_01_preview.implementation;

import com.microsoft.azure.management.datalakestore.v2015_10_01_preview.FirewallRuleProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data Lake Store firewall rule information.
 */
public class FirewallRuleInner {
    /**
     * the firewall rule's name.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * the namespace and type of the firewall Rule.
     */
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private String type;

    /**
     * the firewall rule's subscription ID.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * the firewall rule's regional location.
     */
    @JsonProperty(value = "location")
    private String location;

    /**
     * the properties of the firewall rule.
     */
    @JsonProperty(value = "properties")
    private FirewallRuleProperties properties;

    /**
     * Get the firewall rule's name.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the firewall rule's name.
     *
     * @param name the name value to set
     * @return the FirewallRuleInner object itself.
     */
    public FirewallRuleInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the namespace and type of the firewall Rule.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

    /**
     * Get the firewall rule's subscription ID.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the firewall rule's subscription ID.
     *
     * @param id the id value to set
     * @return the FirewallRuleInner object itself.
     */
    public FirewallRuleInner withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the firewall rule's regional location.
     *
     * @return the location value
     */
    public String location() {
        return this.location;
    }

    /**
     * Set the firewall rule's regional location.
     *
     * @param location the location value to set
     * @return the FirewallRuleInner object itself.
     */
    public FirewallRuleInner withLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * Get the properties of the firewall rule.
     *
     * @return the properties value
     */
    public FirewallRuleProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties of the firewall rule.
     *
     * @param properties the properties value to set
     * @return the FirewallRuleInner object itself.
     */
    public FirewallRuleInner withProperties(FirewallRuleProperties properties) {
        this.properties = properties;
        return this;
    }

}
