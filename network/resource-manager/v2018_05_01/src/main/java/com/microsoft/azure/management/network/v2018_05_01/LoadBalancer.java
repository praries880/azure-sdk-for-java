/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2018_05_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.Resource;
import com.microsoft.azure.arm.resources.models.GroupableResourceCore;
import com.microsoft.azure.arm.resources.models.HasResourceGroup;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.network.v2018_05_01.implementation.NetworkManager;
import java.util.List;
import com.microsoft.azure.management.network.v2018_05_01.implementation.BackendAddressPoolInner;
import com.microsoft.azure.management.network.v2018_05_01.implementation.FrontendIPConfigurationInner;
import com.microsoft.azure.management.network.v2018_05_01.implementation.InboundNatRuleInner;
import com.microsoft.azure.management.network.v2018_05_01.implementation.LoadBalancingRuleInner;
import com.microsoft.azure.management.network.v2018_05_01.implementation.ProbeInner;
import com.microsoft.azure.management.network.v2018_05_01.implementation.LoadBalancerInner;

/**
 * Type representing LoadBalancer.
 */
public interface LoadBalancer extends HasInner<LoadBalancerInner>, Resource, GroupableResourceCore<NetworkManager, LoadBalancerInner>, HasResourceGroup, Refreshable<LoadBalancer>, Updatable<LoadBalancer.Update>, HasManager<NetworkManager> {
    /**
     * @return the backendAddressPools value.
     */
    List<BackendAddressPool> backendAddressPools();

    /**
     * @return the etag value.
     */
    String etag();

    /**
     * @return the frontendIPConfigurations value.
     */
    List<FrontendIPConfiguration> frontendIPConfigurations();

    /**
     * @return the inboundNatPools value.
     */
    List<InboundNatPool> inboundNatPools();

    /**
     * @return the inboundNatRules value.
     */
    List<InboundNatRule> inboundNatRules();

    /**
     * @return the loadBalancingRules value.
     */
    List<LoadBalancingRule> loadBalancingRules();

    /**
     * @return the outboundNatRules value.
     */
    List<OutboundNatRule> outboundNatRules();

    /**
     * @return the probes value.
     */
    List<Probe> probes();

    /**
     * @return the provisioningState value.
     */
    String provisioningState();

    /**
     * @return the resourceGuid value.
     */
    String resourceGuid();

    /**
     * @return the sku value.
     */
    LoadBalancerSku sku();

    /**
     * The entirety of the LoadBalancer definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithGroup, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of LoadBalancer definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a LoadBalancer definition.
         */
        interface Blank extends GroupableResourceCore.DefinitionWithRegion<WithGroup> {
        }

        /**
         * The stage of the LoadBalancer definition allowing to specify the resource group.
         */
        interface WithGroup extends GroupableResourceCore.DefinitionStages.WithGroup<WithCreate> {
        }

        /**
         * The stage of the loadbalancer update allowing to specify BackendAddressPools.
         */
        interface WithBackendAddressPools {
            /**
             * Specifies backendAddressPools.
             */
            WithCreate withBackendAddressPools(List<BackendAddressPoolInner> backendAddressPools);
        }

        /**
         * The stage of the loadbalancer update allowing to specify Etag.
         */
        interface WithEtag {
            /**
             * Specifies etag.
             */
            WithCreate withEtag(String etag);
        }

        /**
         * The stage of the loadbalancer update allowing to specify FrontendIPConfigurations.
         */
        interface WithFrontendIPConfigurations {
            /**
             * Specifies frontendIPConfigurations.
             */
            WithCreate withFrontendIPConfigurations(List<FrontendIPConfigurationInner> frontendIPConfigurations);
        }

        /**
         * The stage of the loadbalancer update allowing to specify InboundNatPools.
         */
        interface WithInboundNatPools {
            /**
             * Specifies inboundNatPools.
             */
            WithCreate withInboundNatPools(List<InboundNatPool> inboundNatPools);
        }

        /**
         * The stage of the loadbalancer update allowing to specify InboundNatRules.
         */
        interface WithInboundNatRules {
            /**
             * Specifies inboundNatRules.
             */
            WithCreate withInboundNatRules(List<InboundNatRuleInner> inboundNatRules);
        }

        /**
         * The stage of the loadbalancer update allowing to specify LoadBalancingRules.
         */
        interface WithLoadBalancingRules {
            /**
             * Specifies loadBalancingRules.
             */
            WithCreate withLoadBalancingRules(List<LoadBalancingRuleInner> loadBalancingRules);
        }

        /**
         * The stage of the loadbalancer update allowing to specify OutboundNatRules.
         */
        interface WithOutboundNatRules {
            /**
             * Specifies outboundNatRules.
             */
            WithCreate withOutboundNatRules(List<OutboundNatRule> outboundNatRules);
        }

        /**
         * The stage of the loadbalancer update allowing to specify Probes.
         */
        interface WithProbes {
            /**
             * Specifies probes.
             */
            WithCreate withProbes(List<ProbeInner> probes);
        }

        /**
         * The stage of the loadbalancer update allowing to specify ProvisioningState.
         */
        interface WithProvisioningState {
            /**
             * Specifies provisioningState.
             */
            WithCreate withProvisioningState(String provisioningState);
        }

        /**
         * The stage of the loadbalancer update allowing to specify ResourceGuid.
         */
        interface WithResourceGuid {
            /**
             * Specifies resourceGuid.
             */
            WithCreate withResourceGuid(String resourceGuid);
        }

        /**
         * The stage of the loadbalancer update allowing to specify Sku.
         */
        interface WithSku {
            /**
             * Specifies sku.
             */
            WithCreate withSku(LoadBalancerSku sku);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<LoadBalancer>, Resource.DefinitionWithTags<WithCreate>, DefinitionStages.WithBackendAddressPools, DefinitionStages.WithEtag, DefinitionStages.WithFrontendIPConfigurations, DefinitionStages.WithInboundNatPools, DefinitionStages.WithInboundNatRules, DefinitionStages.WithLoadBalancingRules, DefinitionStages.WithOutboundNatRules, DefinitionStages.WithProbes, DefinitionStages.WithProvisioningState, DefinitionStages.WithResourceGuid, DefinitionStages.WithSku {
        }
    }
    /**
     * The template for a LoadBalancer update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<LoadBalancer>, Resource.UpdateWithTags<Update>, UpdateStages.WithBackendAddressPools, UpdateStages.WithEtag, UpdateStages.WithFrontendIPConfigurations, UpdateStages.WithInboundNatPools, UpdateStages.WithInboundNatRules, UpdateStages.WithLoadBalancingRules, UpdateStages.WithOutboundNatRules, UpdateStages.WithProbes, UpdateStages.WithProvisioningState, UpdateStages.WithResourceGuid, UpdateStages.WithSku {
    }

    /**
     * Grouping of LoadBalancer update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the loadbalancer {0} allowing to specify BackendAddressPools.
         */
        interface WithBackendAddressPools {
            /**
             * Specifies backendAddressPools.
             */
            Update withBackendAddressPools(List<BackendAddressPoolInner> backendAddressPools);
        }

        /**
         * The stage of the loadbalancer {0} allowing to specify Etag.
         */
        interface WithEtag {
            /**
             * Specifies etag.
             */
            Update withEtag(String etag);
        }

        /**
         * The stage of the loadbalancer {0} allowing to specify FrontendIPConfigurations.
         */
        interface WithFrontendIPConfigurations {
            /**
             * Specifies frontendIPConfigurations.
             */
            Update withFrontendIPConfigurations(List<FrontendIPConfigurationInner> frontendIPConfigurations);
        }

        /**
         * The stage of the loadbalancer {0} allowing to specify InboundNatPools.
         */
        interface WithInboundNatPools {
            /**
             * Specifies inboundNatPools.
             */
            Update withInboundNatPools(List<InboundNatPool> inboundNatPools);
        }

        /**
         * The stage of the loadbalancer {0} allowing to specify InboundNatRules.
         */
        interface WithInboundNatRules {
            /**
             * Specifies inboundNatRules.
             */
            Update withInboundNatRules(List<InboundNatRuleInner> inboundNatRules);
        }

        /**
         * The stage of the loadbalancer {0} allowing to specify LoadBalancingRules.
         */
        interface WithLoadBalancingRules {
            /**
             * Specifies loadBalancingRules.
             */
            Update withLoadBalancingRules(List<LoadBalancingRuleInner> loadBalancingRules);
        }

        /**
         * The stage of the loadbalancer {0} allowing to specify OutboundNatRules.
         */
        interface WithOutboundNatRules {
            /**
             * Specifies outboundNatRules.
             */
            Update withOutboundNatRules(List<OutboundNatRule> outboundNatRules);
        }

        /**
         * The stage of the loadbalancer {0} allowing to specify Probes.
         */
        interface WithProbes {
            /**
             * Specifies probes.
             */
            Update withProbes(List<ProbeInner> probes);
        }

        /**
         * The stage of the loadbalancer {0} allowing to specify ProvisioningState.
         */
        interface WithProvisioningState {
            /**
             * Specifies provisioningState.
             */
            Update withProvisioningState(String provisioningState);
        }

        /**
         * The stage of the loadbalancer {0} allowing to specify ResourceGuid.
         */
        interface WithResourceGuid {
            /**
             * Specifies resourceGuid.
             */
            Update withResourceGuid(String resourceGuid);
        }

        /**
         * The stage of the loadbalancer {0} allowing to specify Sku.
         */
        interface WithSku {
            /**
             * Specifies sku.
             */
            Update withSku(LoadBalancerSku sku);
        }

    }
}
