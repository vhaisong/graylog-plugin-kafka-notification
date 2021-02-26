/*
 * Copyright (C) 2020 Graylog, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Server Side Public License, version 1,
 * as published by MongoDB, Inc.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Server Side Public License for more details.
 *
 * You should have received a copy of the Server Side Public License
 * along with this program. If not, see
 * <http://www.mongodb.com/licensing/server-side-public-license>.
 */
package cn.qingmg.graylog.plugin.kafka.notification;

import cn.qingmg.graylog.plugin.kafka.notification.entity.KafkaEventNotificationConfig;
import cn.qingmg.graylog.plugin.kafka.notification.util.KafkaUtil;
import org.graylog.events.notifications.EventNotification;
import org.graylog.events.notifications.EventNotificationContext;
import org.graylog.events.notifications.EventNotificationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the plugin. Your class should implement one of the existing plugin
 * interfaces. (i.e. AlarmCallback, MessageInput, MessageOutput)
 */
public class KafkaNotification implements EventNotification {

    public interface Factory extends EventNotification.Factory<KafkaNotification> {
        @Override
        KafkaNotification create();
    }

    private static final Logger log = LoggerFactory.getLogger(KafkaNotification.class);

    @Override
    public void execute(EventNotificationContext ctx) throws EventNotificationException {
        /* 获得需要的参数 */
        final KafkaEventNotificationConfig config = (KafkaEventNotificationConfig) ctx.notificationConfig();
        String bootstrapServers = config.bootstrapServers();
        String topic = config.topic();
        String content = config.content();

        /* 获得 Alerts -> Event Definitions -> Fields 的数据 *//*
        Map<String, String> map = ctx.event().fields();
        String value = map.get("key");*/

        log.info("通过kafka发送警告: bootstrapServer: {}, topic: {}", bootstrapServers, topic);
        KafkaUtil.send(bootstrapServers, topic, content);
    }
}