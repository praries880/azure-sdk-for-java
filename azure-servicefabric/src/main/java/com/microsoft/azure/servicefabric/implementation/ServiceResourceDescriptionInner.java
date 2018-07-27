/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.servicefabric.implementation;

import com.microsoft.azure.servicefabric.OperatingSystemTypes;
import java.util.List;
import com.microsoft.azure.servicefabric.ContainerCodePackageProperties;
import com.microsoft.azure.servicefabric.NetworkRef;
import com.microsoft.azure.servicefabric.DiagnosticsRef;
import com.microsoft.azure.servicefabric.HealthState;
import com.microsoft.azure.servicefabric.ServiceResourceStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Describes a service fabric service resource.
 */
@JsonFlatten
public class ServiceResourceDescriptionInner {
    /**
     * The Operating system type required by the code in service. Possible
     * values include: 'Linux', 'Windows'.
     */
    @JsonProperty(value = "properties.osType", required = true)
    private OperatingSystemTypes osType;

    /**
     * Describes the set of code packages that forms the service. A code
     * package describes the container and the properties for running it. All
     * the code packages are started together on the same host and share the
     * same context (network, process etc.).
     */
    @JsonProperty(value = "properties.codePackages", required = true)
    private List<ContainerCodePackageProperties> codePackages;

    /**
     * The names of the private networks that this service needs to be part of.
     */
    @JsonProperty(value = "properties.networkRefs")
    private List<NetworkRef> networkRefs;

    /**
     * Reference to sinks in DiagnosticsDescription.
     */
    @JsonProperty(value = "properties.diagnostics")
    private DiagnosticsRef diagnostics;

    /**
     * User readable description of the service.
     */
    @JsonProperty(value = "properties.description")
    private String description;

    /**
     * The number of replicas of the service to create. Defaults to 1 if not
     * specified.
     */
    @JsonProperty(value = "properties.replicaCount")
    private Integer replicaCount;

    /**
     * The health state of a Service Fabric entity such as Cluster, Node,
     * Application, Service, Partition, Replica etc. Possible values include:
     * 'Invalid', 'Ok', 'Warning', 'Error', 'Unknown'.
     */
    @JsonProperty(value = "properties.healthState")
    private HealthState healthState;

    /**
     * Represents the status of the service. Possible values include:
     * 'Unknown', 'Active', 'Upgrading', 'Deleting', 'Creating', 'Failed'.
     */
    @JsonProperty(value = "properties.status", access = JsonProperty.Access.WRITE_ONLY)
    private ServiceResourceStatus status;

    /**
     * Service resource name.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /**
     * Get the Operating system type required by the code in service. Possible values include: 'Linux', 'Windows'.
     *
     * @return the osType value
     */
    public OperatingSystemTypes osType() {
        return this.osType;
    }

    /**
     * Set the Operating system type required by the code in service. Possible values include: 'Linux', 'Windows'.
     *
     * @param osType the osType value to set
     * @return the ServiceResourceDescriptionInner object itself.
     */
    public ServiceResourceDescriptionInner withOsType(OperatingSystemTypes osType) {
        this.osType = osType;
        return this;
    }

    /**
     * Get describes the set of code packages that forms the service. A code package describes the container and the properties for running it. All the code packages are started together on the same host and share the same context (network, process etc.).
     *
     * @return the codePackages value
     */
    public List<ContainerCodePackageProperties> codePackages() {
        return this.codePackages;
    }

    /**
     * Set describes the set of code packages that forms the service. A code package describes the container and the properties for running it. All the code packages are started together on the same host and share the same context (network, process etc.).
     *
     * @param codePackages the codePackages value to set
     * @return the ServiceResourceDescriptionInner object itself.
     */
    public ServiceResourceDescriptionInner withCodePackages(List<ContainerCodePackageProperties> codePackages) {
        this.codePackages = codePackages;
        return this;
    }

    /**
     * Get the names of the private networks that this service needs to be part of.
     *
     * @return the networkRefs value
     */
    public List<NetworkRef> networkRefs() {
        return this.networkRefs;
    }

    /**
     * Set the names of the private networks that this service needs to be part of.
     *
     * @param networkRefs the networkRefs value to set
     * @return the ServiceResourceDescriptionInner object itself.
     */
    public ServiceResourceDescriptionInner withNetworkRefs(List<NetworkRef> networkRefs) {
        this.networkRefs = networkRefs;
        return this;
    }

    /**
     * Get reference to sinks in DiagnosticsDescription.
     *
     * @return the diagnostics value
     */
    public DiagnosticsRef diagnostics() {
        return this.diagnostics;
    }

    /**
     * Set reference to sinks in DiagnosticsDescription.
     *
     * @param diagnostics the diagnostics value to set
     * @return the ServiceResourceDescriptionInner object itself.
     */
    public ServiceResourceDescriptionInner withDiagnostics(DiagnosticsRef diagnostics) {
        this.diagnostics = diagnostics;
        return this;
    }

    /**
     * Get user readable description of the service.
     *
     * @return the description value
     */
    public String description() {
        return this.description;
    }

    /**
     * Set user readable description of the service.
     *
     * @param description the description value to set
     * @return the ServiceResourceDescriptionInner object itself.
     */
    public ServiceResourceDescriptionInner withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the number of replicas of the service to create. Defaults to 1 if not specified.
     *
     * @return the replicaCount value
     */
    public Integer replicaCount() {
        return this.replicaCount;
    }

    /**
     * Set the number of replicas of the service to create. Defaults to 1 if not specified.
     *
     * @param replicaCount the replicaCount value to set
     * @return the ServiceResourceDescriptionInner object itself.
     */
    public ServiceResourceDescriptionInner withReplicaCount(Integer replicaCount) {
        this.replicaCount = replicaCount;
        return this;
    }

    /**
     * Get the health state of a Service Fabric entity such as Cluster, Node, Application, Service, Partition, Replica etc. Possible values include: 'Invalid', 'Ok', 'Warning', 'Error', 'Unknown'.
     *
     * @return the healthState value
     */
    public HealthState healthState() {
        return this.healthState;
    }

    /**
     * Set the health state of a Service Fabric entity such as Cluster, Node, Application, Service, Partition, Replica etc. Possible values include: 'Invalid', 'Ok', 'Warning', 'Error', 'Unknown'.
     *
     * @param healthState the healthState value to set
     * @return the ServiceResourceDescriptionInner object itself.
     */
    public ServiceResourceDescriptionInner withHealthState(HealthState healthState) {
        this.healthState = healthState;
        return this;
    }

    /**
     * Get represents the status of the service. Possible values include: 'Unknown', 'Active', 'Upgrading', 'Deleting', 'Creating', 'Failed'.
     *
     * @return the status value
     */
    public ServiceResourceStatus status() {
        return this.status;
    }

    /**
     * Get service resource name.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set service resource name.
     *
     * @param name the name value to set
     * @return the ServiceResourceDescriptionInner object itself.
     */
    public ServiceResourceDescriptionInner withName(String name) {
        this.name = name;
        return this;
    }

}
