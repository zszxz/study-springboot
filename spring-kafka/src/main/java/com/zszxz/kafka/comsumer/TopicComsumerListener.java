package com.zszxz.kafka.comsumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author lsc
 * <p> </p>
 */
@Component
@Slf4j
public class TopicComsumerListener {

    @KafkaListener(topics = {"zszxz_topic"})
    public void consumer(ConsumerRecord<?, ?> consumerRecord) {
        log.info("收到的数据-----：{}", consumerRecord.toString());
    }

}
