/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.containerregistry.v2018_02_01_preview.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.containerregistry.v2018_02_01_preview.BuildTasks;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.containerregistry.v2018_02_01_preview.SourceRepositoryProperties;
import com.microsoft.azure.management.containerregistry.v2018_02_01_preview.BuildTask;

class BuildTasksImpl extends WrapperImpl<BuildTasksInner> implements BuildTasks {
    private final ContainerRegistryManager manager;

    BuildTasksImpl(ContainerRegistryManager manager) {
        super(manager.inner().buildTasks());
        this.manager = manager;
    }

    public ContainerRegistryManager manager() {
        return this.manager;
    }

    @Override
    public BuildTaskImpl define(String name) {
        return wrapModel(name);
    }

    private BuildTaskImpl wrapModel(BuildTaskInner inner) {
        return  new BuildTaskImpl(inner, manager());
    }

    private BuildTaskImpl wrapModel(String name) {
        return new BuildTaskImpl(name, this.manager());
    }

    @Override
    public Observable<SourceRepositoryProperties> listSourceRepositoryPropertiesAsync(String resourceGroupName, String registryName, String buildTaskName) {
        BuildTasksInner client = this.inner();
        return client.listSourceRepositoryPropertiesAsync(resourceGroupName, registryName, buildTaskName)
        .map(new Func1<SourceRepositoryPropertiesInner, SourceRepositoryProperties>() {
            @Override
            public SourceRepositoryProperties call(SourceRepositoryPropertiesInner inner) {
                return new SourceRepositoryPropertiesImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<BuildTask> listAsync(final String resourceGroupName, final String registryName) {
        BuildTasksInner client = this.inner();
        return client.listAsync(resourceGroupName, registryName)
        .flatMapIterable(new Func1<Page<BuildTaskInner>, Iterable<BuildTaskInner>>() {
            @Override
            public Iterable<BuildTaskInner> call(Page<BuildTaskInner> page) {
                return page.items();
            }
        })
        .map(new Func1<BuildTaskInner, BuildTask>() {
            @Override
            public BuildTask call(BuildTaskInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public Observable<BuildTask> getAsync(String resourceGroupName, String registryName, String buildTaskName) {
        BuildTasksInner client = this.inner();
        return client.getAsync(resourceGroupName, registryName, buildTaskName)
        .map(new Func1<BuildTaskInner, BuildTask>() {
            @Override
            public BuildTask call(BuildTaskInner inner) {
                return wrapModel(inner);
            }
       });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String registryName, String buildTaskName) {
        BuildTasksInner client = this.inner();
        return client.deleteAsync(resourceGroupName, registryName, buildTaskName).toCompletable();
    }

}
