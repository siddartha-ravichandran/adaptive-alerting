/*
 * Copyright 2018 Expedia Group, Inc.
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
package com.expedia.aquila.util;

import com.expedia.adaptivealerting.core.data.Mpoint;

import java.util.UUID;

/**
 * @author Willie Wheeler
 */
public final class AnomalyDetectorUtil {
    
    public static final UUID toDetectorUuid(Mpoint mpoint) {
        // FIXME Hardcoded til MetricRouter can assign detector UUIDs. [WLW]
        return UUID.fromString("636e13ed-6882-48cc-be75-56986a3b0179");
    }
}