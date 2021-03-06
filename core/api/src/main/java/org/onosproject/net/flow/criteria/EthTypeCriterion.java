/*
 * Copyright 2015 Open Networking Laboratory
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
package org.onosproject.net.flow.criteria;

import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * Implementation of Ethernet type criterion (16 bits unsigned integer).
 */
public final class EthTypeCriterion implements Criterion {
    private static final int MASK = 0xffff;
    private final int ethType;              // Ethernet type value: 16 bits

    /**
     * Constructor.
     *
     * @param ethType the Ethernet frame type to match (16 bits unsigned
     * integer)
     */
    EthTypeCriterion(int ethType) {
        this.ethType = ethType & MASK;
    }

    @Override
    public Type type() {
        return Type.ETH_TYPE;
    }

    /**
     * Gets the Ethernet frame type to match.
     *
     * @return the Ethernet frame type to match (16 bits unsigned integer)
     */
    public int ethType() {
        return ethType;
    }

    @Override
    public String toString() {
        return toStringHelper(type().toString())
                .add("ethType", Long.toHexString(ethType))
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(type(), ethType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EthTypeCriterion) {
            EthTypeCriterion that = (EthTypeCriterion) obj;
            return Objects.equals(ethType, that.ethType) &&
                    Objects.equals(this.type(), that.type());
        }
        return false;
    }
}
