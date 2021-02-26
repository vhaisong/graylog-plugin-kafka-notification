package cn.qingmg.graylog.plugin.kafka.notification.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import org.graylog.events.contentpack.entities.EventNotificationConfigEntity;
import org.graylog.events.notifications.EventNotificationConfig;
import org.graylog2.contentpacks.model.entities.EntityDescriptor;
import org.graylog2.contentpacks.model.entities.references.ValueReference;

import java.util.Map;

/**
 * implements EventNotificationConfigEntity
 *
 * @author vhs
 * @version 1.0
 * @date 2021-02-25
 */
@AutoValue
@JsonTypeName(KafkaEventNotificationConfig.TYPE_NAME)
@JsonDeserialize(builder = KafkaEventNotificationConfigEntity.Builder.class)
public abstract class KafkaEventNotificationConfigEntity implements EventNotificationConfigEntity {

    /**
     * 需要的参数
     * String bootstrapServers, String topic, String content
     */
    private static final String FIELD_BOOTSTRAP_SERVERS = "bootstrapServers";
    private static final String FIELD_TOPIC = "topic";
    private static final String FIELD_CONTENT = "content";

    @JsonProperty(FIELD_BOOTSTRAP_SERVERS)
    public abstract ValueReference bootstrapServers();

    @JsonProperty(FIELD_TOPIC)
    public abstract ValueReference topic();

    @JsonProperty(FIELD_CONTENT)
    public abstract ValueReference content();

    public static Builder builder() {
        return Builder.create();
    }

    @AutoValue.Builder
    public static abstract class Builder implements EventNotificationConfigEntity.Builder<Builder> {

        @JsonCreator
        public static Builder create() {
            return new AutoValue_KafkaEventNotificationConfigEntity.Builder()
                    .type(KafkaEventNotificationConfig.TYPE_NAME);
        }

        @JsonProperty(FIELD_BOOTSTRAP_SERVERS)
        public abstract Builder bootstrapServers(ValueReference bootstrapServers);

        @JsonProperty(FIELD_TOPIC)
        public abstract Builder topic(ValueReference topic);

        @JsonProperty(FIELD_CONTENT)
        public abstract Builder content(ValueReference content);

        public abstract KafkaEventNotificationConfigEntity build();
    }

    @Override
    public EventNotificationConfig toNativeEntity(Map<String, ValueReference> parameters, Map<EntityDescriptor, Object> nativeEntities) {
        return KafkaEventNotificationConfig.builder()
                .bootstrapServers(bootstrapServers().asString(parameters))
                .topic(topic().asString(parameters))
                .content(content().asString(parameters))
                .build();
    }
}
