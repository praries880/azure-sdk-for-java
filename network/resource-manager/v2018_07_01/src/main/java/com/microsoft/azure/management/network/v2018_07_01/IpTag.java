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
 * Contains the IpTag associated with the object.
 */
public class IpTag {
    /**
     * Gets or sets the ipTag type: Example FirstPartyUsage.
     */
    @JsonProperty(value = "ipTagType")
    private String ipTagType;

    /**
     * Gets or sets value of the IpTag associated with the public IP. Example
     * SQL, Storage etc.
     */
    @JsonProperty(value = "tag")
    private String tag;

    /**
     * Get gets or sets the ipTag type: Example FirstPartyUsage.
     *
     * @return the ipTagType value
     */
    public String ipTagType() {
        return this.ipTagType;
    }

    /**
     * Set gets or sets the ipTag type: Example FirstPartyUsage.
     *
     * @param ipTagType the ipTagType value to set
     * @return the IpTag object itself.
     */
    public IpTag withIpTagType(String ipTagType) {
        this.ipTagType = ipTagType;
        return this;
    }

    /**
     * Get gets or sets value of the IpTag associated with the public IP. Example SQL, Storage etc.
     *
     * @return the tag value
     */
    public String tag() {
        return this.tag;
    }

    /**
     * Set gets or sets value of the IpTag associated with the public IP. Example SQL, Storage etc.
     *
     * @param tag the tag value to set
     * @return the IpTag object itself.
     */
    public IpTag withTag(String tag) {
        this.tag = tag;
        return this;
    }

}
