/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.v2018_06_01_preview.implementation;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Summary of revision metadata.
 */
public class ApiRevisionContractInner {
    /**
     * Identifier of the API Revision.
     */
    @JsonProperty(value = "apiId", access = JsonProperty.Access.WRITE_ONLY)
    private String apiId;

    /**
     * Revision number of API.
     */
    @JsonProperty(value = "apiRevision", access = JsonProperty.Access.WRITE_ONLY)
    private String apiRevision;

    /**
     * The time the API Revision was created. The date conforms to the
     * following format: yyyy-MM-ddTHH:mm:ssZ as specified by the ISO 8601
     * standard.
     */
    @JsonProperty(value = "createdDateTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime createdDateTime;

    /**
     * The time the API Revision were updated. The date conforms to the
     * following format: yyyy-MM-ddTHH:mm:ssZ as specified by the ISO 8601
     * standard.
     */
    @JsonProperty(value = "updatedDateTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime updatedDateTime;

    /**
     * Description of the API Revision.
     */
    @JsonProperty(value = "description", access = JsonProperty.Access.WRITE_ONLY)
    private String description;

    /**
     * Gateway URL for accessing the non-current API Revision.
     */
    @JsonProperty(value = "privateUrl", access = JsonProperty.Access.WRITE_ONLY)
    private String privateUrl;

    /**
     * Indicates if API revision is the current api revision.
     */
    @JsonProperty(value = "isOnline", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isOnline;

    /**
     * Indicates if API revision is accessible via the gateway.
     */
    @JsonProperty(value = "isCurrent", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isCurrent;

    /**
     * Get identifier of the API Revision.
     *
     * @return the apiId value
     */
    public String apiId() {
        return this.apiId;
    }

    /**
     * Get revision number of API.
     *
     * @return the apiRevision value
     */
    public String apiRevision() {
        return this.apiRevision;
    }

    /**
     * Get the time the API Revision was created. The date conforms to the following format: yyyy-MM-ddTHH:mm:ssZ as specified by the ISO 8601 standard.
     *
     * @return the createdDateTime value
     */
    public DateTime createdDateTime() {
        return this.createdDateTime;
    }

    /**
     * Get the time the API Revision were updated. The date conforms to the following format: yyyy-MM-ddTHH:mm:ssZ as specified by the ISO 8601 standard.
     *
     * @return the updatedDateTime value
     */
    public DateTime updatedDateTime() {
        return this.updatedDateTime;
    }

    /**
     * Get description of the API Revision.
     *
     * @return the description value
     */
    public String description() {
        return this.description;
    }

    /**
     * Get gateway URL for accessing the non-current API Revision.
     *
     * @return the privateUrl value
     */
    public String privateUrl() {
        return this.privateUrl;
    }

    /**
     * Get indicates if API revision is the current api revision.
     *
     * @return the isOnline value
     */
    public Boolean isOnline() {
        return this.isOnline;
    }

    /**
     * Get indicates if API revision is accessible via the gateway.
     *
     * @return the isCurrent value
     */
    public Boolean isCurrent() {
        return this.isCurrent;
    }

}
