/*
 * Copyright (C) 2020 The zfoo Authors
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package com.zfoo.net.router;

import com.zfoo.protocol.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 同步或异步的调用控制器
 *
 * @author jaysunxiao
 * @version 3.0
 */
public class PacketSignalMap {

    private static final Logger logger = LoggerFactory.getLogger(PacketSignalMap.class);

    private static final Map<Integer, Integer> signalAttachmentMap = new ConcurrentHashMap<>(1_0000);

    public static void addSignalAttachment(int packetId) {
        signalAttachmentMap.put(packetId, packetId);
    }


    public static void removeSignalAttachment(int packetId) {
        signalAttachmentMap.remove(packetId);
    }

    public static void status() {
        signalAttachmentMap.forEach((key, value) -> {
            logger.info("signalAttachmentMap has attachment [key:{}][value:{}]", key, JsonUtils.object2String(value));
        });
    }

}
