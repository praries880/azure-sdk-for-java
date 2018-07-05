/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.trafficmanager.v2018_03_01.implementation;

import com.microsoft.azure.management.trafficmanager.v2018_03_01.TrafficManagerGeographicHierarchy;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.trafficmanager.v2018_03_01.Region;

class TrafficManagerGeographicHierarchyImpl extends WrapperImpl<TrafficManagerGeographicHierarchyInner> implements TrafficManagerGeographicHierarchy {
    private final NetworkManager manager;
    TrafficManagerGeographicHierarchyImpl(TrafficManagerGeographicHierarchyInner inner, NetworkManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public NetworkManager manager() {
        return this.manager;
    }

    @Override
    public Region geographicHierarchy() {
        return this.inner().geographicHierarchy();
    }

    @Override
    public String id() {
        return this.inner().id();
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
