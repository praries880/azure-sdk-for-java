/*
 * The MIT License (MIT)
 * Copyright (c) 2018 Microsoft Corporation
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.azure.data.cosmos;

import com.azure.data.cosmos.internal.Constants;
import com.azure.data.cosmos.internal.Strings;
import com.azure.data.cosmos.internal.routing.PartitionKeyInternal;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a partition key definition in the Azure Cosmos DB database service. A partition key definition specifies which
 * document property is used as the partition key in a collection that has multiple partitions.
 */
public final class PartitionKeyDefinition extends JsonSerializable {
    private List<String> paths;
    private PartitionKind kind;
    private PartitionKeyDefinitionVersion version;
    private Boolean systemKey;

    /**
     * Constructor. Creates a new instance of the PartitionKeyDefinition object.
     */
    public PartitionKeyDefinition() {
        this.kind(PartitionKind.HASH);
    }

    /**
     * Constructor. Creates a new instance of the PartitionKeyDefinition object from a
     * JSON string.
     *
     * @param jsonString the JSON string that represents the partition key definition.
     */
    PartitionKeyDefinition(String jsonString) {
        super(jsonString);
    }

    /**
     * Sets the partition algorithm used to calculate the partition id given a partition key.
     *
     * @return the partition algorithm.
     */
    public PartitionKind kind() {
        if (this.kind == null) {
            this.kind = super.getObject(Constants.Properties.PARTITION_KIND, PartitionKind.class, true);
        }

        return this.kind;
    }

    /**
     * Sets the partition algorithm used to calculate the partition id given a partition key.
     *
     * @param kind the partition algorithm.
     * @return this PartitionKeyDefinition.
     */
    public PartitionKeyDefinition kind(PartitionKind kind) {
        this.kind = kind;
        return this;
    }

    public PartitionKeyDefinitionVersion version() {
        if (this.version == null) {
            Object versionObject = super.getObject(Constants.Properties.PARTITION_KEY_DEFINITION_VERSION, Object.class);
            if (versionObject == null) {
                this.version = null;
            } else {
                String versionStr = String.valueOf(versionObject);
                if (StringUtils.isNumeric(versionStr)) {
                    this.version = PartitionKeyDefinitionVersion.valueOf(String.format("V%d", Integer.parseInt(versionStr)));
                } else {
                    this.version = !Strings.isNullOrEmpty(versionStr)
                            ? PartitionKeyDefinitionVersion.valueOf(StringUtils.upperCase(versionStr))
                            : null;
                }
            }
        }

        return this.version;
    }

    public PartitionKeyDefinition version(PartitionKeyDefinitionVersion version) {
        this.version = version;
        return this;
    }

    /**
     * Gets the document property paths for the partition key.
     *
     * @return the paths to the document properties that form the partition key.
     */
    public List<String> paths() {
        if (this.paths == null) {
            if (super.has(Constants.Properties.PARTITION_KEY_PATHS)) {
                paths = super.getList(Constants.Properties.PARTITION_KEY_PATHS, String.class);
            } else {
                paths = new ArrayList<>();
            }
        }

        return paths;
    }

    /**
     * Sets the document property paths for the partition key.
     *
     * @param paths the paths to document properties that form the partition key.
     * @return this PartitionKeyDefinition.
     */
    public PartitionKeyDefinition paths(List<String> paths) {
        if (paths == null || paths.size() == 0) {
            throw new IllegalArgumentException("paths must not be null or empty.");
        }

        this.paths = paths;
        return this;
    }

    /**
     * Indicates if the partition key is generated by the system.
     *
     * @return the boolean indicating is it is a system key.
     */
    Boolean isSystemKey() {
        if (this.systemKey == null) {
            if (super.has(Constants.Properties.SYSTEM_KEY)) {
                this.systemKey = super.getBoolean(Constants.Properties.SYSTEM_KEY);
            } else {
                this.systemKey = false;
            }
        }

        return this.systemKey;
    }

    PartitionKeyInternal getNonePartitionKeyValue() {
        if (this.paths().size() == 0 || this.isSystemKey()) {
            return PartitionKeyInternal.Empty;
        } else {
            return PartitionKeyInternal.UndefinedPartitionKey;
        }
    }

    @Override
    void populatePropertyBag() {
        if (this.kind != null) {
            super.set(Constants.Properties.PARTITION_KIND, kind.toString());
        }
        if (this.paths != null) {
            super.set(Constants.Properties.PARTITION_KEY_PATHS, paths);
        }

        if (this.version != null) {
            super.set(Constants.Properties.PARTITION_KEY_DEFINITION_VERSION, version.toString());
        }
        super.populatePropertyBag();
    }
}
