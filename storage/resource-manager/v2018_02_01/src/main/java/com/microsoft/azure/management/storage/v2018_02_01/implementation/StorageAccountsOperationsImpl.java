/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * abc
 */

package com.microsoft.azure.management.storage.v2018_02_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.storage.v2018_02_01.StorageAccountsOperations;
import com.microsoft.azure.management.storage.v2018_02_01.BlobServices;

class StorageAccountsOperationsImpl extends WrapperImpl<BlobContainersInner> implements StorageAccountsOperations {
    private final StorageManager manager;

    StorageAccountsOperationsImpl(StorageManager manager) {
        super(manager.inner().blobContainers());
        this.manager = manager;
    }

    @Override
    public BlobServices blobServices() {
        BlobServices accessor = this.manager().blobServices();
        return accessor;
    }

    public StorageManager manager() {
        return this.manager;
    }

}