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

import com.proofpoint.json.JsonCodec;
import org.testng.annotations.Test;

import static com.proofpoint.testing.EquivalenceTester.equivalenceTester;
import static org.testng.Assert.assertEquals;

public class TestInstanceCreationRequest
{

    private JsonCodec<InstanceCreationRequest> icrJsonCodec = JsonCodec.jsonCodec(InstanceCreationRequest.class);

    @Test
    public void testEquivalence()
    {
        equivalenceTester()
                .addEquivalentGroup(new InstanceCreationRequest("a", 1), new InstanceCreationRequest("a", 1))
                .addEquivalentGroup(new InstanceCreationRequest("b", 1), new InstanceCreationRequest("b", 1))
                .addEquivalentGroup(new InstanceCreationRequest("a", 2), new InstanceCreationRequest("a", 2))
                .check();
    }

    @Test
    public void testJsonMarshalling()
    {
        InstanceCreationRequest instanceCreationRequest = new InstanceCreationRequest("a", 1);
        String jsonInstanceCreationRequest = icrJsonCodec.toJson(instanceCreationRequest);
        InstanceCreationRequest encodedInstanceCreationRequest = icrJsonCodec.fromJson(jsonInstanceCreationRequest);
        assertEquals(instanceCreationRequest, encodedInstanceCreationRequest);
    }
}