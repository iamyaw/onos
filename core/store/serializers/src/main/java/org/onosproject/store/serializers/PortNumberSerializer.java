/*
 * Copyright 2014 Open Networking Laboratory
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
package org.onosproject.store.serializers;

import org.onosproject.net.PortNumber;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Serializer for {@link PortNumber}.
 */
public final class PortNumberSerializer extends
        Serializer<PortNumber> {

    /**
     * Creates {@link PortNumber} serializer instance.
     */
    public PortNumberSerializer() {
        // non-null, immutable
        super(false, true);
    }

    @Override
    public void write(Kryo kryo, Output output, PortNumber object) {
        output.writeBoolean(object.hasName());
        output.writeLong(object.toLong());
        if (object.hasName()) {
            output.writeString(object.name());
        }
    }

    @Override
    public PortNumber read(Kryo kryo, Input input, Class<PortNumber> type) {
        if (input.readBoolean()) {
            return PortNumber.portNumber(input.readLong(), input.readString());
        } else {
            return PortNumber.portNumber(input.readLong());
        }
    }
}
