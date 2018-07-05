/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.trafficmanager.v2017_03_01;

import rx.Observable;
import com.microsoft.azure.management.trafficmanager.v2017_03_01.implementation.GeographicHierarchiesInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing GeographicHierarchies.
 */
public interface GeographicHierarchies extends HasInner<GeographicHierarchiesInner> {
    /**
     * Gets the default Geographic Hierarchy used by the Geographic traffic routing method.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<TrafficManagerGeographicHierarchy> getDefaultAsync();

}
