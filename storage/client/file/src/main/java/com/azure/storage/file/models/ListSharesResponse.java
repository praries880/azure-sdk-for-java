// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.file.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * An enumeration of shares.
 */
@JacksonXmlRootElement(localName = "EnumerationResults")
public final class ListSharesResponse {
    /*
     * The serviceEndpoint property.
     */
    @JacksonXmlProperty(localName = "ServiceEndpoint", isAttribute = true)
    private String serviceEndpoint;

    /*
     * The prefix property.
     */
    @JsonProperty(value = "Prefix")
    private String prefix;

    /*
     * The marker property.
     */
    @JsonProperty(value = "Marker")
    private String marker;

    /*
     * The maxResults property.
     */
    @JsonProperty(value = "MaxResults")
    private Integer maxResults;

    private static final class SharesWrapper {
        @JacksonXmlProperty(localName = "Share")
        private final List<ShareItem> items;

        @JsonCreator
        private SharesWrapper(@JacksonXmlProperty(localName = "Share") List<ShareItem> items) {
            this.items = items;
        }
    }

    /*
     * The shareItems property.
     */
    @JsonProperty(value = "Shares")
    private SharesWrapper shareItems;

    /*
     * The nextMarker property.
     */
    @JsonProperty(value = "NextMarker", required = true)
    private String nextMarker;

    /**
     * Get the serviceEndpoint property: The serviceEndpoint property.
     *
     * @return the serviceEndpoint value.
     */
    public String serviceEndpoint() {
        return this.serviceEndpoint;
    }

    /**
     * Set the serviceEndpoint property: The serviceEndpoint property.
     *
     * @param serviceEndpoint the serviceEndpoint value to set.
     * @return the ListSharesResponse object itself.
     */
    public ListSharesResponse serviceEndpoint(String serviceEndpoint) {
        this.serviceEndpoint = serviceEndpoint;
        return this;
    }

    /**
     * Get the prefix property: The prefix property.
     *
     * @return the prefix value.
     */
    public String prefix() {
        return this.prefix;
    }

    /**
     * Set the prefix property: The prefix property.
     *
     * @param prefix the prefix value to set.
     * @return the ListSharesResponse object itself.
     */
    public ListSharesResponse prefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    /**
     * Get the marker property: The marker property.
     *
     * @return the marker value.
     */
    public String marker() {
        return this.marker;
    }

    /**
     * Set the marker property: The marker property.
     *
     * @param marker the marker value to set.
     * @return the ListSharesResponse object itself.
     */
    public ListSharesResponse marker(String marker) {
        this.marker = marker;
        return this;
    }

    /**
     * Get the maxResults property: The maxResults property.
     *
     * @return the maxResults value.
     */
    public Integer maxResults() {
        return this.maxResults;
    }

    /**
     * Set the maxResults property: The maxResults property.
     *
     * @param maxResults the maxResults value to set.
     * @return the ListSharesResponse object itself.
     */
    public ListSharesResponse maxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }

    /**
     * Get the shareItems property: The shareItems property.
     *
     * @return the shareItems value.
     */
    public List<ShareItem> shareItems() {
        if (this.shareItems == null) {
            this.shareItems = new SharesWrapper(new ArrayList<ShareItem>());
        }
        return this.shareItems.items;
    }

    /**
     * Set the shareItems property: The shareItems property.
     *
     * @param shareItems the shareItems value to set.
     * @return the ListSharesResponse object itself.
     */
    public ListSharesResponse shareItems(List<ShareItem> shareItems) {
        this.shareItems = new SharesWrapper(shareItems);
        return this;
    }

    /**
     * Get the nextMarker property: The nextMarker property.
     *
     * @return the nextMarker value.
     */
    public String nextMarker() {
        return this.nextMarker;
    }

    /**
     * Set the nextMarker property: The nextMarker property.
     *
     * @param nextMarker the nextMarker value to set.
     * @return the ListSharesResponse object itself.
     */
    public ListSharesResponse nextMarker(String nextMarker) {
        this.nextMarker = nextMarker;
        return this;
    }
}
