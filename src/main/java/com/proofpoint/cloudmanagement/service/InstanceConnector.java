/*
 * Copyright 2010 Proofpoint, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.proofpoint.cloudmanagement.service;

public interface InstanceConnector
{
    public enum InstanceDestructionStatus
    {
        DESTROYED, NOT_FOUND
    }

    public Iterable<Instance> getAllInstances();

    public Instance getInstance(String instanceId);

    public InstanceDestructionStatus destroyInstance(String id);

    public String createInstance(String sizeName, String namePrefix, String locationId);

    public Iterable<Size> getSizes(String location);

    public String getName();

    public Iterable<Location> getLocations();

    public Location getLocation(String location);
}
