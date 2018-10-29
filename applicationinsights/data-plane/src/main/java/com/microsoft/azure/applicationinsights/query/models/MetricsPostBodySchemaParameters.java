/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.applicationinsights.query.models;

import java.util.List;
import org.joda.time.Period;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The parameters for a single metrics query.
 */
public class MetricsPostBodySchemaParameters {
    /**
     * Possible values include: 'requests/count', 'requests/duration',
     * 'requests/failed', 'users/count', 'users/authenticated',
     * 'pageViews/count', 'pageViews/duration', 'client/processingDuration',
     * 'client/receiveDuration', 'client/networkDuration',
     * 'client/sendDuration', 'client/totalDuration', 'dependencies/count',
     * 'dependencies/failed', 'dependencies/duration', 'exceptions/count',
     * 'exceptions/browser', 'exceptions/server', 'sessions/count',
     * 'performanceCounters/requestExecutionTime',
     * 'performanceCounters/requestsPerSecond',
     * 'performanceCounters/requestsInQueue',
     * 'performanceCounters/memoryAvailableBytes',
     * 'performanceCounters/exceptionsPerSecond',
     * 'performanceCounters/processCpuPercentage',
     * 'performanceCounters/processIOBytesPerSecond',
     * 'performanceCounters/processPrivateBytes',
     * 'performanceCounters/processorCpuPercentage',
     * 'availabilityResults/availabilityPercentage',
     * 'availabilityResults/duration', 'billing/telemetryCount',
     * 'customEvents/count'.
     */
    @JsonProperty(value = "metricId", required = true)
    private MetricId metricId;

    /**
     * The timespan property.
     */
    @JsonProperty(value = "timespan")
    private String timespan;

    /**
     * The aggregation property.
     */
    @JsonProperty(value = "aggregation")
    private List<MetricsAggregation> aggregation;

    /**
     * The interval property.
     */
    @JsonProperty(value = "interval")
    private Period interval;

    /**
     * The segment property.
     */
    @JsonProperty(value = "segment")
    private List<MetricsSegment> segment;

    /**
     * The top property.
     */
    @JsonProperty(value = "top")
    private Integer top;

    /**
     * The orderby property.
     */
    @JsonProperty(value = "orderby")
    private String orderby;

    /**
     * The filter property.
     */
    @JsonProperty(value = "filter")
    private String filter;

    /**
     * Get possible values include: 'requests/count', 'requests/duration', 'requests/failed', 'users/count', 'users/authenticated', 'pageViews/count', 'pageViews/duration', 'client/processingDuration', 'client/receiveDuration', 'client/networkDuration', 'client/sendDuration', 'client/totalDuration', 'dependencies/count', 'dependencies/failed', 'dependencies/duration', 'exceptions/count', 'exceptions/browser', 'exceptions/server', 'sessions/count', 'performanceCounters/requestExecutionTime', 'performanceCounters/requestsPerSecond', 'performanceCounters/requestsInQueue', 'performanceCounters/memoryAvailableBytes', 'performanceCounters/exceptionsPerSecond', 'performanceCounters/processCpuPercentage', 'performanceCounters/processIOBytesPerSecond', 'performanceCounters/processPrivateBytes', 'performanceCounters/processorCpuPercentage', 'availabilityResults/availabilityPercentage', 'availabilityResults/duration', 'billing/telemetryCount', 'customEvents/count'.
     *
     * @return the metricId value
     */
    public MetricId metricId() {
        return this.metricId;
    }

    /**
     * Set possible values include: 'requests/count', 'requests/duration', 'requests/failed', 'users/count', 'users/authenticated', 'pageViews/count', 'pageViews/duration', 'client/processingDuration', 'client/receiveDuration', 'client/networkDuration', 'client/sendDuration', 'client/totalDuration', 'dependencies/count', 'dependencies/failed', 'dependencies/duration', 'exceptions/count', 'exceptions/browser', 'exceptions/server', 'sessions/count', 'performanceCounters/requestExecutionTime', 'performanceCounters/requestsPerSecond', 'performanceCounters/requestsInQueue', 'performanceCounters/memoryAvailableBytes', 'performanceCounters/exceptionsPerSecond', 'performanceCounters/processCpuPercentage', 'performanceCounters/processIOBytesPerSecond', 'performanceCounters/processPrivateBytes', 'performanceCounters/processorCpuPercentage', 'availabilityResults/availabilityPercentage', 'availabilityResults/duration', 'billing/telemetryCount', 'customEvents/count'.
     *
     * @param metricId the metricId value to set
     * @return the MetricsPostBodySchemaParameters object itself.
     */
    public MetricsPostBodySchemaParameters withMetricId(MetricId metricId) {
        this.metricId = metricId;
        return this;
    }

    /**
     * Get the timespan value.
     *
     * @return the timespan value
     */
    public String timespan() {
        return this.timespan;
    }

    /**
     * Set the timespan value.
     *
     * @param timespan the timespan value to set
     * @return the MetricsPostBodySchemaParameters object itself.
     */
    public MetricsPostBodySchemaParameters withTimespan(String timespan) {
        this.timespan = timespan;
        return this;
    }

    /**
     * Get the aggregation value.
     *
     * @return the aggregation value
     */
    public List<MetricsAggregation> aggregation() {
        return this.aggregation;
    }

    /**
     * Set the aggregation value.
     *
     * @param aggregation the aggregation value to set
     * @return the MetricsPostBodySchemaParameters object itself.
     */
    public MetricsPostBodySchemaParameters withAggregation(List<MetricsAggregation> aggregation) {
        this.aggregation = aggregation;
        return this;
    }

    /**
     * Get the interval value.
     *
     * @return the interval value
     */
    public Period interval() {
        return this.interval;
    }

    /**
     * Set the interval value.
     *
     * @param interval the interval value to set
     * @return the MetricsPostBodySchemaParameters object itself.
     */
    public MetricsPostBodySchemaParameters withInterval(Period interval) {
        this.interval = interval;
        return this;
    }

    /**
     * Get the segment value.
     *
     * @return the segment value
     */
    public List<MetricsSegment> segment() {
        return this.segment;
    }

    /**
     * Set the segment value.
     *
     * @param segment the segment value to set
     * @return the MetricsPostBodySchemaParameters object itself.
     */
    public MetricsPostBodySchemaParameters withSegment(List<MetricsSegment> segment) {
        this.segment = segment;
        return this;
    }

    /**
     * Get the top value.
     *
     * @return the top value
     */
    public Integer top() {
        return this.top;
    }

    /**
     * Set the top value.
     *
     * @param top the top value to set
     * @return the MetricsPostBodySchemaParameters object itself.
     */
    public MetricsPostBodySchemaParameters withTop(Integer top) {
        this.top = top;
        return this;
    }

    /**
     * Get the orderby value.
     *
     * @return the orderby value
     */
    public String orderby() {
        return this.orderby;
    }

    /**
     * Set the orderby value.
     *
     * @param orderby the orderby value to set
     * @return the MetricsPostBodySchemaParameters object itself.
     */
    public MetricsPostBodySchemaParameters withOrderby(String orderby) {
        this.orderby = orderby;
        return this;
    }

    /**
     * Get the filter value.
     *
     * @return the filter value
     */
    public String filter() {
        return this.filter;
    }

    /**
     * Set the filter value.
     *
     * @param filter the filter value to set
     * @return the MetricsPostBodySchemaParameters object itself.
     */
    public MetricsPostBodySchemaParameters withFilter(String filter) {
        this.filter = filter;
        return this;
    }

}
