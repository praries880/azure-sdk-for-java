/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.recoveryservices.v2016_06_01.implementation;

import com.microsoft.azure.management.recoveryservices.v2016_06_01.VaultExtendedInfoResource;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;

class VaultExtendedInfoResourceImpl extends WrapperImpl<VaultExtendedInfoResourceInner> implements VaultExtendedInfoResource {
    private final RecoveryServicesManager manager;
    VaultExtendedInfoResourceImpl(VaultExtendedInfoResourceInner inner, RecoveryServicesManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public RecoveryServicesManager manager() {
        return this.manager;
    }

    @Override
    public String algorithm() {
        return this.inner().algorithm();
    }

    @Override
    public String encryptionKey() {
        return this.inner().encryptionKey();
    }

    @Override
    public String encryptionKeyThumbprint() {
        return this.inner().encryptionKeyThumbprint();
    }

    @Override
    public String eTag() {
        return this.inner().eTag();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String integrityKey() {
        return this.inner().integrityKey();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

}
