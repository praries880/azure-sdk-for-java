/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.hdinsight.v2018_06_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The data disks groups for the role.
 */
public class DataDisksGroups {
    /**
     * The number of disks per node.
     */
    @JsonProperty(value = "disksPerNode")
    private Integer disksPerNode;

    /**
     * ReadOnly. The storage account type. Do not set this value.
     */
    @JsonProperty(value = "storageAccountType", access = JsonProperty.Access.WRITE_ONLY)
    private String storageAccountType;

    /**
     * ReadOnly. The DiskSize in GB. Do not set this value.
     */
    @JsonProperty(value = "diskSizeGB", access = JsonProperty.Access.WRITE_ONLY)
    private Integer diskSizeGB;

    /**
     * Get the number of disks per node.
     *
     * @return the disksPerNode value
     */
    public Integer disksPerNode() {
        return this.disksPerNode;
    }

    /**
     * Set the number of disks per node.
     *
     * @param disksPerNode the disksPerNode value to set
     * @return the DataDisksGroups object itself.
     */
    public DataDisksGroups withDisksPerNode(Integer disksPerNode) {
        this.disksPerNode = disksPerNode;
        return this;
    }

    /**
     * Get readOnly. The storage account type. Do not set this value.
     *
     * @return the storageAccountType value
     */
    public String storageAccountType() {
        return this.storageAccountType;
    }

    /**
     * Get readOnly. The DiskSize in GB. Do not set this value.
     *
     * @return the diskSizeGB value
     */
    public Integer diskSizeGB() {
        return this.diskSizeGB;
    }

}
