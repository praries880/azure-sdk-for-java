/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2018_04_01.implementation;

import com.microsoft.azure.SubResource;
import com.microsoft.azure.management.network.v2018_04_01.VpnConnectionStatus;
import java.util.List;
import com.microsoft.azure.management.network.v2018_04_01.IpsecPolicy;
import com.microsoft.azure.management.network.v2018_04_01.ProvisioningState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.rest.SkipParentValidation;
import com.microsoft.azure.Resource;

/**
 * VpnConnection Resource.
 */
@JsonFlatten
@SkipParentValidation
public class VpnConnectionInner extends Resource {
    /**
     * Id of the connected vpn site.
     */
    @JsonProperty(value = "properties.remoteVpnSite")
    private SubResource remoteVpnSite;

    /**
     * routing weight for vpn connection.
     */
    @JsonProperty(value = "properties.routingWeight")
    private Integer routingWeight;

    /**
     * The connection status. Possible values include: 'Unknown', 'Connecting',
     * 'Connected', 'NotConnected'.
     */
    @JsonProperty(value = "properties.connectionStatus")
    private VpnConnectionStatus connectionStatus;

    /**
     * Ingress bytes transferred.
     */
    @JsonProperty(value = "properties.ingressBytesTransferred", access = JsonProperty.Access.WRITE_ONLY)
    private Long ingressBytesTransferred;

    /**
     * Egress bytes transferred.
     */
    @JsonProperty(value = "properties.egressBytesTransferred", access = JsonProperty.Access.WRITE_ONLY)
    private Long egressBytesTransferred;

    /**
     * Expected bandwidth in MBPS.
     */
    @JsonProperty(value = "properties.connectionBandwidth", access = JsonProperty.Access.WRITE_ONLY)
    private Integer connectionBandwidth;

    /**
     * SharedKey for the vpn connection.
     */
    @JsonProperty(value = "properties.sharedKey")
    private String sharedKey;

    /**
     * EnableBgp flag.
     */
    @JsonProperty(value = "properties.enableBgp")
    private Boolean enableBgp;

    /**
     * The IPSec Policies to be considered by this connection.
     */
    @JsonProperty(value = "properties.ipsecPolicies")
    private List<IpsecPolicy> ipsecPolicies;

    /**
     * The provisioning state of the resource. Possible values include:
     * 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState")
    private ProvisioningState provisioningState;

    /**
     * Gets a unique read-only string that changes whenever the resource is
     * updated.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /**
     * Resource ID.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * Get id of the connected vpn site.
     *
     * @return the remoteVpnSite value
     */
    public SubResource remoteVpnSite() {
        return this.remoteVpnSite;
    }

    /**
     * Set id of the connected vpn site.
     *
     * @param remoteVpnSite the remoteVpnSite value to set
     * @return the VpnConnectionInner object itself.
     */
    public VpnConnectionInner withRemoteVpnSite(SubResource remoteVpnSite) {
        this.remoteVpnSite = remoteVpnSite;
        return this;
    }

    /**
     * Get routing weight for vpn connection.
     *
     * @return the routingWeight value
     */
    public Integer routingWeight() {
        return this.routingWeight;
    }

    /**
     * Set routing weight for vpn connection.
     *
     * @param routingWeight the routingWeight value to set
     * @return the VpnConnectionInner object itself.
     */
    public VpnConnectionInner withRoutingWeight(Integer routingWeight) {
        this.routingWeight = routingWeight;
        return this;
    }

    /**
     * Get the connection status. Possible values include: 'Unknown', 'Connecting', 'Connected', 'NotConnected'.
     *
     * @return the connectionStatus value
     */
    public VpnConnectionStatus connectionStatus() {
        return this.connectionStatus;
    }

    /**
     * Set the connection status. Possible values include: 'Unknown', 'Connecting', 'Connected', 'NotConnected'.
     *
     * @param connectionStatus the connectionStatus value to set
     * @return the VpnConnectionInner object itself.
     */
    public VpnConnectionInner withConnectionStatus(VpnConnectionStatus connectionStatus) {
        this.connectionStatus = connectionStatus;
        return this;
    }

    /**
     * Get ingress bytes transferred.
     *
     * @return the ingressBytesTransferred value
     */
    public Long ingressBytesTransferred() {
        return this.ingressBytesTransferred;
    }

    /**
     * Get egress bytes transferred.
     *
     * @return the egressBytesTransferred value
     */
    public Long egressBytesTransferred() {
        return this.egressBytesTransferred;
    }

    /**
     * Get expected bandwidth in MBPS.
     *
     * @return the connectionBandwidth value
     */
    public Integer connectionBandwidth() {
        return this.connectionBandwidth;
    }

    /**
     * Get sharedKey for the vpn connection.
     *
     * @return the sharedKey value
     */
    public String sharedKey() {
        return this.sharedKey;
    }

    /**
     * Set sharedKey for the vpn connection.
     *
     * @param sharedKey the sharedKey value to set
     * @return the VpnConnectionInner object itself.
     */
    public VpnConnectionInner withSharedKey(String sharedKey) {
        this.sharedKey = sharedKey;
        return this;
    }

    /**
     * Get enableBgp flag.
     *
     * @return the enableBgp value
     */
    public Boolean enableBgp() {
        return this.enableBgp;
    }

    /**
     * Set enableBgp flag.
     *
     * @param enableBgp the enableBgp value to set
     * @return the VpnConnectionInner object itself.
     */
    public VpnConnectionInner withEnableBgp(Boolean enableBgp) {
        this.enableBgp = enableBgp;
        return this;
    }

    /**
     * Get the IPSec Policies to be considered by this connection.
     *
     * @return the ipsecPolicies value
     */
    public List<IpsecPolicy> ipsecPolicies() {
        return this.ipsecPolicies;
    }

    /**
     * Set the IPSec Policies to be considered by this connection.
     *
     * @param ipsecPolicies the ipsecPolicies value to set
     * @return the VpnConnectionInner object itself.
     */
    public VpnConnectionInner withIpsecPolicies(List<IpsecPolicy> ipsecPolicies) {
        this.ipsecPolicies = ipsecPolicies;
        return this;
    }

    /**
     * Get the provisioning state of the resource. Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Set the provisioning state of the resource. Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     *
     * @param provisioningState the provisioningState value to set
     * @return the VpnConnectionInner object itself.
     */
    public VpnConnectionInner withProvisioningState(ProvisioningState provisioningState) {
        this.provisioningState = provisioningState;
        return this;
    }

    /**
     * Get gets a unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get resource ID.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set resource ID.
     *
     * @param id the id value to set
     * @return the VpnConnectionInner object itself.
     */
    public VpnConnectionInner withId(String id) {
        this.id = id;
        return this;
    }

}
