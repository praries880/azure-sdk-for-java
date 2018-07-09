/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.billing.v2018_05_31_preview.implementation;

import com.microsoft.azure.management.billing.v2018_05_31_preview.BillingProfile;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;

class BillingProfileImpl extends CreatableUpdatableImpl<BillingProfile, BillingProfileInner, BillingProfileImpl> implements BillingProfile, BillingProfile.Update {
    private final BillingManager manager;
    private String billingAccountId;
    private String billingProfileId;

    BillingProfileImpl(String name, BillingManager manager) {
        super(name, new BillingProfileInner());
        this.manager = manager;
        // Set resource name
        this.billingProfileId = name;
        //
    }

    BillingProfileImpl(BillingProfileInner inner, BillingManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.billingProfileId = inner.name();
        // resource ancestor names
        this.billingAccountId = IdParsingUtils.getValueFromIdByName(inner.id(), "billingAccounts");
        this.billingProfileId = IdParsingUtils.getValueFromIdByName(inner.id(), "billingProfiles");
        //
    }

    @Override
    public BillingManager manager() {
        return this.manager;
    }

    @Override
    public Observable<BillingProfile> createResourceAsync() {
        BillingProfilesInner client = this.manager().inner().billingProfiles();
        return null; // NOP createResourceAsync implementation as create is not supported
    }

    @Override
    public Observable<BillingProfile> updateResourceAsync() {
        BillingProfilesInner client = this.manager().inner().billingProfiles();
        return client.updateAsync(this.billingAccountId, this.billingProfileId, this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<BillingProfileInner> getInnerAsync() {
        BillingProfilesInner client = this.manager().inner().billingProfiles();
        return client.getAsync(this.billingAccountId, this.billingProfileId);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }


    @Override
    public String billingAddress() {
        return this.inner().billingAddress();
    }

    @Override
    public String billingContact() {
        return this.inner().billingContact();
    }

    @Override
    public String currency() {
        return this.inner().currency();
    }

    @Override
    public String displayName() {
        return this.inner().displayName();
    }

    @Override
    public Boolean emailInvoice() {
        return this.inner().emailInvoice();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String invoiceDay() {
        return this.inner().invoiceDay();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public String poNumber() {
        return this.inner().poNumber();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public BillingProfileImpl withDisplayName(String displayName) {
        this.inner().withDisplayName(displayName);
        return this;
    }

    @Override
    public BillingProfileImpl withPoNumber(String poNumber) {
        this.inner().withPoNumber(poNumber);
        return this;
    }

}
