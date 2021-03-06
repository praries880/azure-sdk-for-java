/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.v2014_04_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.sql.v2014_04_01.implementation.ServerAzureADAdministratorInner;
import com.microsoft.azure.arm.model.Indexable;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.sql.v2014_04_01.implementation.SqlManager;
import java.util.UUID;

/**
 * Type representing ServerAzureADAdministrator.
 */
public interface ServerAzureADAdministrator extends HasInner<ServerAzureADAdministratorInner>, Indexable, Refreshable<ServerAzureADAdministrator>, Updatable<ServerAzureADAdministrator.Update>, HasManager<SqlManager> {
    /**
     * @return the administratorType value.
     */
    String administratorType();

    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the login value.
     */
    String login();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the sid value.
     */
    UUID sid();

    /**
     * @return the tenantId value.
     */
    UUID tenantId();

    /**
     * @return the type value.
     */
    String type();

    /**
     * The entirety of the ServerAzureADAdministrator definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithServer, DefinitionStages.WithAdministratorType, DefinitionStages.WithLogin, DefinitionStages.WithSid, DefinitionStages.WithTenantId, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of ServerAzureADAdministrator definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a ServerAzureADAdministrator definition.
         */
        interface Blank extends WithServer {
        }

        /**
         * The stage of the serverazureadadministrator definition allowing to specify Server.
         */
        interface WithServer {
           /**
            * Specifies resourceGroupName, serverName.
            * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal
            * @param serverName The name of the server
            * @return the next definition stage
            */
            WithAdministratorType withExistingServer(String resourceGroupName, String serverName);
        }

        /**
         * The stage of the serverazureadadministrator definition allowing to specify AdministratorType.
         */
        interface WithAdministratorType {
           /**
            * Specifies administratorType.
            * @param administratorType The type of administrator
            * @return the next definition stage
            */
            WithLogin withAdministratorType(String administratorType);
        }

        /**
         * The stage of the serverazureadadministrator definition allowing to specify Login.
         */
        interface WithLogin {
           /**
            * Specifies login.
            * @param login The server administrator login value
            * @return the next definition stage
            */
            WithSid withLogin(String login);
        }

        /**
         * The stage of the serverazureadadministrator definition allowing to specify Sid.
         */
        interface WithSid {
           /**
            * Specifies sid.
            * @param sid The server administrator Sid (Secure ID)
            * @return the next definition stage
            */
            WithTenantId withSid(UUID sid);
        }

        /**
         * The stage of the serverazureadadministrator definition allowing to specify TenantId.
         */
        interface WithTenantId {
           /**
            * Specifies tenantId.
            * @param tenantId The server Active Directory Administrator tenant id
            * @return the next definition stage
            */
            WithCreate withTenantId(UUID tenantId);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<ServerAzureADAdministrator> {
        }
    }
    /**
     * The template for a ServerAzureADAdministrator update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<ServerAzureADAdministrator> {
    }

    /**
     * Grouping of ServerAzureADAdministrator update stages.
     */
    interface UpdateStages {
    }
}
