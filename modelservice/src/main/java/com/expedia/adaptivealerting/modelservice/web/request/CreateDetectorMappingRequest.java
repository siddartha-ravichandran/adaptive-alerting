/*
 * Copyright 2018-2019 Expedia Group, Inc.
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
package com.expedia.adaptivealerting.modelservice.web.request;

import com.expedia.adaptivealerting.modelservice.domain.mapping.ConsumerDetectorMapping;
import com.expedia.adaptivealerting.modelservice.domain.mapping.Expression;
import com.expedia.adaptivealerting.modelservice.domain.mapping.User;
import com.expedia.adaptivealerting.modelservice.util.RequestValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDetectorMappingRequest {
    private Expression expression;
    private ConsumerDetectorMapping consumerDetectorMapping;
    private User user;

    public void validate() {
        RequestValidator.validateExpression(this.getExpression());
        RequestValidator.validateUser(this.getUser());
        RequestValidator.validateMappingDetector(this.getConsumerDetectorMapping());
    }

    public Set<String> getFields() {
        return this.expression.getOperands().stream()
                .map(operand -> operand.getField().getKey()).collect(Collectors.toSet());
    }
}


