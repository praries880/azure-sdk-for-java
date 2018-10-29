/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.notificationhubs.v2014_09_01;

import com.microsoft.azure.arm.collection.SupportsCreating;
import rx.Completable;
import rx.Observable;
import com.microsoft.azure.management.notificationhubs.v2014_09_01.implementation.NotificationHubsInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing NotificationHubs.
 */
public interface NotificationHubs extends SupportsCreating<NotificationHubResource.DefinitionStages.Blank>, HasInner<NotificationHubsInner> {
    /**
     * Begins definition for a new AuthorizationRule resource.
     * @param name resource name.
     * @return the first stage of the new AuthorizationRule definition.
     */
    NotificationHubNamespaceSharedAccessAuthorizationRuleResource.DefinitionStages.Blank defineAuthorizationRule(String name);

    /**
     * Gets the authorization rules for a NotificationHub.
     *
     * @param resourceGroupName The name of the resource group.
     * @param namespaceName The namespace name
     * @param notificationHubName The notification hub name.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<NamespaceSharedAccessAuthorizationRuleResource> listAuthorizationRulesAsync(final String resourceGroupName, final String namespaceName, final String notificationHubName);

    /**
     * Lists the PNS Credentials associated with a notification hub .
     *
     * @param resourceGroupName The name of the resource group.
     * @param namespaceName The namespace name.
     * @param notificationHubName The notification hub name.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<NotificationHubResource> getPnsCredentialsAsync(String resourceGroupName, String namespaceName, String notificationHubName);

    /**
     * Lists the notification hubs associated with a namespace.
     *
     * @param resourceGroupName The name of the resource group.
     * @param namespaceName The namespace name.
     * @param notificationHubName The notification hub name.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<NotificationHubResource> getAsync(String resourceGroupName, String namespaceName, String notificationHubName);

    /**
     * Lists the notification hubs associated with a namespace.
     *
     * @param resourceGroupName The name of the resource group.
     * @param namespaceName The namespace name.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<NotificationHubResource> listAsync(final String resourceGroupName, final String namespaceName);

    /**
     * Deletes a notification hub associated with a namespace.
     *
     * @param resourceGroupName The name of the resource group.
     * @param namespaceName The namespace name.
     * @param notificationHubName The notification hub name.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable deleteAsync(String resourceGroupName, String namespaceName, String notificationHubName);

    /**
     * Checks the availability of the given notificationHub in a namespace.
     *
     * @param resourceGroupName The name of the resource group.
     * @param namespaceName The namespace name.
     * @param parameters The notificationHub name.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<CheckAvailabilityResource> checkAvailabilityAsync(String resourceGroupName, String namespaceName, CheckAvailabilityParameters parameters);

    /**
     * Deletes a notificationHub authorization rule.
     *
     * @param resourceGroupName The name of the resource group.
     * @param namespaceName The namespace name.
     * @param notificationHubName The notification hub name.
     * @param authorizationRuleName Authorization Rule Name.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable deleteAuthorizationRuleAsync(String resourceGroupName, String namespaceName, String notificationHubName, String authorizationRuleName);

    /**
     * Gets an authorization rule for a NotificationHub by name.
     *
     * @param resourceGroupName The name of the resource group.
     * @param namespaceName The namespace name
     * @param notificationHubName The notification hub name.
     * @param authorizationRuleName authorization rule name.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<NamespaceSharedAccessAuthorizationRuleResource> getAuthorizationRuleAsync(String resourceGroupName, String namespaceName, String notificationHubName, String authorizationRuleName);

    /**
     * Gets the Primary and Secondary ConnectionStrings to the NotificationHub.
     *
     * @param resourceGroupName The name of the resource group.
     * @param namespaceName The namespace name.
     * @param notificationHubName The notification hub name.
     * @param authorizationRuleName The connection string of the NotificationHub for the specified authorizationRule.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ResourceListKeys> listKeysAsync(String resourceGroupName, String namespaceName, String notificationHubName, String authorizationRuleName);

}
