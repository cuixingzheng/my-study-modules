package com.kafka.test.demo.kafka;

import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: cxz
 * @create: 2020/9/24 11:34
 * @description:
 **/
@Configuration
@EnableKafka
public class KafkaConsumerConfig {

//    private final Logger log = Logger.getLogger(KafkaConsumerConfig.class);
//
//    private Map<String, Object> consumerProps() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kf1.kafka.test.duia.com:9092");
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
//        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
//        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
//        //一次拉取消息数量
//        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "2");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, NumberDeserializers.IntegerDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        return props;
//    }
//
//    @Bean("batchContainerFactory")
//    public ConcurrentKafkaListenerContainerFactory listenerContainer() {
//        ConcurrentKafkaListenerContainerFactory container = new ConcurrentKafkaListenerContainerFactory();
//        container.setConsumerFactory(new DefaultKafkaConsumerFactory(consumerProps()));
//        //设置并发量，小于或等于Topic的分区数
//        container.setConcurrency(1);
//        //设置为批量监听
//        container.setBatchListener(true);
//        return container;
//    }

//    //@KafkaListener(id = "batch",clientIdPrefix = "batch",topics = {"topic.quick.batch"},containerFactory = "batchContainerFactory")
//    @KafkaListener(topics = {"ai_errorVideoDataTemp"}, containerFactory = "batchContainerFactory")
//    public void batchListener(List<ConsumerRecord<?, ?> > records, Acknowledgment ack) {
//        log.info("ai_errorVideoDataTemp  receive : ");
//        for (ConsumerRecord s : records) {
//            log.info(  s.value());
//        }
//    }



}
