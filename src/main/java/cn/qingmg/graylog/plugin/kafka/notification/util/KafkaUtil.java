package cn.qingmg.graylog.plugin.kafka.notification.util;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * kafka 极简工具类
 *
 * @author vhs
 * @version 1.0
 * @date 2021-02-25
 */
public class KafkaUtil {

    /**
     * 发送消息
     *
     * @param bootstrapServers 地址
     * @param topic            主题
     * @param content          消息内容
     */
    public static void send(String bootstrapServers, String topic, String content) {
        Properties props = new Properties();
        // broker地址
        props.put("bootstrap.servers", bootstrapServers);
        // 请求的时候需要验证
        props.put("acks", "all");
        // 请求失败需要重试jps
        props.put("retries", "0");
        // 内存缓存区大小
        props.put("buffer.memory", 33554432);
        // 指定消息key序列化方式
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        // 指定消息本身的序列化方式
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<>(
                topic, content));

        producer.close();
    }
}
