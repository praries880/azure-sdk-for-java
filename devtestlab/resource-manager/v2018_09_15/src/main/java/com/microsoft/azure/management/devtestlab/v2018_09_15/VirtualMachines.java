/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlab.v2018_09_15;

import com.microsoft.azure.arm.collection.SupportsCreating;
import rx.Completable;
import rx.Observable;
import com.microsoft.azure.management.devtestlab.v2018_09_15.implementation.VirtualMachinesInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing VirtualMachines.
 */
public interface VirtualMachines extends SupportsCreating<LabVirtualMachine.DefinitionStages.Blank>, HasInner<VirtualMachinesInner> {
    /**
     * Attach a new or existing data disk to virtual machine. This operation can take a while to complete.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the virtual machine.
     * @param dataDiskProperties Request body for adding a new or existing data disk to a virtual machine.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable addDataDiskAsync(String resourceGroupName, String labName, String name, DataDiskProperties dataDiskProperties);

    /**
     * Apply artifacts to virtual machine. This operation can take a while to complete.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the virtual machine.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable applyArtifactsAsync(String resourceGroupName, String labName, String name);

    /**
     * Take ownership of an existing virtual machine This operation can take a while to complete.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the virtual machine.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable claimAsync(String resourceGroupName, String labName, String name);

    /**
     * Detach the specified disk from the virtual machine. This operation can take a while to complete.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the virtual machine.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable detachDataDiskAsync(String resourceGroupName, String labName, String name);

    /**
     * Gets a string that represents the contents of the RDP file for the virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the virtual machine.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<RdpConnection> getRdpFileContentsAsync(String resourceGroupName, String labName, String name);

    /**
     * Lists the applicable start/stop schedules, if any.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the virtual machine.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ApplicableSchedule> listApplicableSchedulesAsync(String resourceGroupName, String labName, String name);

    /**
     * Redeploy a virtual machine This operation can take a while to complete.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the virtual machine.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable redeployAsync(String resourceGroupName, String labName, String name);

    /**
     * Resize Virtual Machine. This operation can take a while to complete.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the virtual machine.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable resizeAsync(String resourceGroupName, String labName, String name);

    /**
     * Restart a virtual machine. This operation can take a while to complete.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the virtual machine.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable restartAsync(String resourceGroupName, String labName, String name);

    /**
     * Start a virtual machine. This operation can take a while to complete.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the virtual machine.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable startAsync(String resourceGroupName, String labName, String name);

    /**
     * Stop a virtual machine This operation can take a while to complete.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the virtual machine.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable stopAsync(String resourceGroupName, String labName, String name);

    /**
     * Transfers all data disks attached to the virtual machine to be owned by the current user. This operation can take a while to complete.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the virtual machine.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable transferDisksAsync(String resourceGroupName, String labName, String name);

    /**
     * Release ownership of an existing virtual machine This operation can take a while to complete.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the virtual machine.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable unClaimAsync(String resourceGroupName, String labName, String name);

    /**
     * Get virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the virtual machine.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<LabVirtualMachine> getAsync(String resourceGroupName, String labName, String name);

    /**
     * List virtual machines in a given lab.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<LabVirtualMachine> listAsync(final String resourceGroupName, final String labName);

    /**
     * Delete virtual machine. This operation can take a while to complete.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the virtual machine.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable deleteAsync(String resourceGroupName, String labName, String name);

}
