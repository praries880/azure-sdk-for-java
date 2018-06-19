/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2017_10_01;

import com.microsoft.azure.SubResource;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Redirect configuration of an application gateway.
 */
@JsonFlatten
public class ApplicationGatewayRedirectConfiguration extends SubResource {
    /**
     * Supported http redirection types - Permanent, Temporary, Found,
     * SeeOther. Possible values include: 'Permanent', 'Found', 'SeeOther',
     * 'Temporary'.
     */
    @JsonProperty(value = "properties.redirectType")
    private ApplicationGatewayRedirectType redirectType;

    /**
     * Reference to a listener to redirect the request to.
     */
    @JsonProperty(value = "properties.targetListener")
    private SubResource targetListener;

    /**
     * Url to redirect the request to.
     */
    @JsonProperty(value = "properties.targetUrl")
    private String targetUrl;

    /**
     * Include path in the redirected url.
     */
    @JsonProperty(value = "properties.includePath")
    private Boolean includePath;

    /**
     * Include query string in the redirected url.
     */
    @JsonProperty(value = "properties.includeQueryString")
    private Boolean includeQueryString;

    /**
     * Request routing specifying redirect configuration.
     */
    @JsonProperty(value = "properties.requestRoutingRules")
    private List<SubResource> requestRoutingRules;

    /**
     * Url path maps specifying default redirect configuration.
     */
    @JsonProperty(value = "properties.urlPathMaps")
    private List<SubResource> urlPathMaps;

    /**
     * Path rules specifying redirect configuration.
     */
    @JsonProperty(value = "properties.pathRules")
    private List<SubResource> pathRules;

    /**
     * Name of the resource that is unique within a resource group. This name
     * can be used to access the resource.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag")
    private String etag;

    /**
     * Type of the resource.
     */
    @JsonProperty(value = "type")
    private String type;

    /**
     * Get supported http redirection types - Permanent, Temporary, Found, SeeOther. Possible values include: 'Permanent', 'Found', 'SeeOther', 'Temporary'.
     *
     * @return the redirectType value
     */
    public ApplicationGatewayRedirectType redirectType() {
        return this.redirectType;
    }

    /**
     * Set supported http redirection types - Permanent, Temporary, Found, SeeOther. Possible values include: 'Permanent', 'Found', 'SeeOther', 'Temporary'.
     *
     * @param redirectType the redirectType value to set
     * @return the ApplicationGatewayRedirectConfiguration object itself.
     */
    public ApplicationGatewayRedirectConfiguration withRedirectType(ApplicationGatewayRedirectType redirectType) {
        this.redirectType = redirectType;
        return this;
    }

    /**
     * Get reference to a listener to redirect the request to.
     *
     * @return the targetListener value
     */
    public SubResource targetListener() {
        return this.targetListener;
    }

    /**
     * Set reference to a listener to redirect the request to.
     *
     * @param targetListener the targetListener value to set
     * @return the ApplicationGatewayRedirectConfiguration object itself.
     */
    public ApplicationGatewayRedirectConfiguration withTargetListener(SubResource targetListener) {
        this.targetListener = targetListener;
        return this;
    }

    /**
     * Get url to redirect the request to.
     *
     * @return the targetUrl value
     */
    public String targetUrl() {
        return this.targetUrl;
    }

    /**
     * Set url to redirect the request to.
     *
     * @param targetUrl the targetUrl value to set
     * @return the ApplicationGatewayRedirectConfiguration object itself.
     */
    public ApplicationGatewayRedirectConfiguration withTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
        return this;
    }

    /**
     * Get include path in the redirected url.
     *
     * @return the includePath value
     */
    public Boolean includePath() {
        return this.includePath;
    }

    /**
     * Set include path in the redirected url.
     *
     * @param includePath the includePath value to set
     * @return the ApplicationGatewayRedirectConfiguration object itself.
     */
    public ApplicationGatewayRedirectConfiguration withIncludePath(Boolean includePath) {
        this.includePath = includePath;
        return this;
    }

    /**
     * Get include query string in the redirected url.
     *
     * @return the includeQueryString value
     */
    public Boolean includeQueryString() {
        return this.includeQueryString;
    }

    /**
     * Set include query string in the redirected url.
     *
     * @param includeQueryString the includeQueryString value to set
     * @return the ApplicationGatewayRedirectConfiguration object itself.
     */
    public ApplicationGatewayRedirectConfiguration withIncludeQueryString(Boolean includeQueryString) {
        this.includeQueryString = includeQueryString;
        return this;
    }

    /**
     * Get request routing specifying redirect configuration.
     *
     * @return the requestRoutingRules value
     */
    public List<SubResource> requestRoutingRules() {
        return this.requestRoutingRules;
    }

    /**
     * Set request routing specifying redirect configuration.
     *
     * @param requestRoutingRules the requestRoutingRules value to set
     * @return the ApplicationGatewayRedirectConfiguration object itself.
     */
    public ApplicationGatewayRedirectConfiguration withRequestRoutingRules(List<SubResource> requestRoutingRules) {
        this.requestRoutingRules = requestRoutingRules;
        return this;
    }

    /**
     * Get url path maps specifying default redirect configuration.
     *
     * @return the urlPathMaps value
     */
    public List<SubResource> urlPathMaps() {
        return this.urlPathMaps;
    }

    /**
     * Set url path maps specifying default redirect configuration.
     *
     * @param urlPathMaps the urlPathMaps value to set
     * @return the ApplicationGatewayRedirectConfiguration object itself.
     */
    public ApplicationGatewayRedirectConfiguration withUrlPathMaps(List<SubResource> urlPathMaps) {
        this.urlPathMaps = urlPathMaps;
        return this;
    }

    /**
     * Get path rules specifying redirect configuration.
     *
     * @return the pathRules value
     */
    public List<SubResource> pathRules() {
        return this.pathRules;
    }

    /**
     * Set path rules specifying redirect configuration.
     *
     * @param pathRules the pathRules value to set
     * @return the ApplicationGatewayRedirectConfiguration object itself.
     */
    public ApplicationGatewayRedirectConfiguration withPathRules(List<SubResource> pathRules) {
        this.pathRules = pathRules;
        return this;
    }

    /**
     * Get name of the resource that is unique within a resource group. This name can be used to access the resource.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set name of the resource that is unique within a resource group. This name can be used to access the resource.
     *
     * @param name the name value to set
     * @return the ApplicationGatewayRedirectConfiguration object itself.
     */
    public ApplicationGatewayRedirectConfiguration withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get a unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Set a unique read-only string that changes whenever the resource is updated.
     *
     * @param etag the etag value to set
     * @return the ApplicationGatewayRedirectConfiguration object itself.
     */
    public ApplicationGatewayRedirectConfiguration withEtag(String etag) {
        this.etag = etag;
        return this;
    }

    /**
     * Get type of the resource.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

    /**
     * Set type of the resource.
     *
     * @param type the type value to set
     * @return the ApplicationGatewayRedirectConfiguration object itself.
     */
    public ApplicationGatewayRedirectConfiguration withType(String type) {
        this.type = type;
        return this;
    }

}
