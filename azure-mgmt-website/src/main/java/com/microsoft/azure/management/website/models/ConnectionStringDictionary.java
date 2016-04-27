/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.website.models;

import java.util.Map;
import com.microsoft.azure.Resource;

/**
 * String dictionary resource.
 */
public class ConnectionStringDictionary extends Resource {
    /**
     * Connection strings.
     */
    private Map<String, ConnStringValueTypePair> properties;

    /**
     * Get the properties value.
     *
     * @return the properties value
     */
    public Map<String, ConnStringValueTypePair> getProperties() {
        return this.properties;
    }

    /**
     * Set the properties value.
     *
     * @param properties the properties value to set
     */
    public void setProperties(Map<String, ConnStringValueTypePair> properties) {
        this.properties = properties;
    }

}