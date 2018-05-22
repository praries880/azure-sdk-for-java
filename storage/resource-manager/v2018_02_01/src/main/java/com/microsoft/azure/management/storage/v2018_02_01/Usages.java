/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.storage.v2018_02_01;

import rx.Observable;
import com.microsoft.azure.management.storage.v2018_02_01.implementation.UsagesInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing Usages.
 */
public interface Usages extends HasInner<UsagesInner> {

    /**
     * Gets the current usage count and the limit for the resources of the location under the subscription.
     *
     * @param location The location of the Azure Storage resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<Usage> listByLocationAsync(String location);
    /**
     * Gets the current usage count and the limit for the resources under the subscription.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<Usage> listAsync();

}