/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.logic.v2016_06_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The key attributes.
 */
public class KeyVaultKeyAttributes {
    /**
     * Whether the key is enabled or not.
     */
    @JsonProperty(value = "enabled")
    private Boolean enabled;

    /**
     * When the key was created.
     */
    @JsonProperty(value = "created")
    private Long created;

    /**
     * When the key was updated.
     */
    @JsonProperty(value = "updated")
    private Long updated;

    /**
     * Get the enabled value.
     *
     * @return the enabled value
     */
    public Boolean enabled() {
        return this.enabled;
    }

    /**
     * Set the enabled value.
     *
     * @param enabled the enabled value to set
     * @return the KeyVaultKeyAttributes object itself.
     */
    public KeyVaultKeyAttributes withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get the created value.
     *
     * @return the created value
     */
    public Long created() {
        return this.created;
    }

    /**
     * Set the created value.
     *
     * @param created the created value to set
     * @return the KeyVaultKeyAttributes object itself.
     */
    public KeyVaultKeyAttributes withCreated(Long created) {
        this.created = created;
        return this;
    }

    /**
     * Get the updated value.
     *
     * @return the updated value
     */
    public Long updated() {
        return this.updated;
    }

    /**
     * Set the updated value.
     *
     * @param updated the updated value to set
     * @return the KeyVaultKeyAttributes object itself.
     */
    public KeyVaultKeyAttributes withUpdated(Long updated) {
        this.updated = updated;
        return this;
    }

}