/**
 * 项目名：duia-statistic-api <br>
 * 包名：com.duia.statistic.common.data <br>
 * 文件名：GlobalKafkaConsumerConfiguration.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2017年5月4日-下午12:02:57<br>
 * Copyright (c) 2017 赵增斌-版权所有<br>
 */
package com.kafka.test.demo.kafka;

import com.kafka.test.demo.config.ConfigKafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名称：GlobalKafkaConsumerConfiguration <br>
 * 类描述：kafka消费者配置文件 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2017年5月4日 下午12:02:57 <br>l
 * 修改备注：TODO <br>
 */
@Configuration
@EnableKafka
public class GlobalKafkaConsumerConfiguration {

    /**
     * 日志
     */
    private static final Logger LOGGER = Logger.getLogger(GlobalKafkaConsumerConfiguration.class);

    @Autowired
    private ConfigKafkaConsumer configKafkaConsumer;

    /**
     * 方法：kafkaListenerContainerFactory <br>
     * 描述：Kafka监听器工厂类 <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年5月12日 下午5:40:51 <br>
     *
     * @return
     */
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(1);
       //设置为批量监听
        factory.setBatchListener(true);
        factory.getContainerProperties().setPollTimeout(15000);
        factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.AckMode.MANUAL_IMMEDIATE);
        return factory;
    }


   /* @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerSparkFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerSparkFactory());
        factory.setConcurrency(3);
        factory.getContainerProperties().setPollTimeout(15000);
        factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.AckMode.MANUAL_IMMEDIATE);
        return factory;
    }*/

    /**
     * 方法：consumerConfigs <br>
     * 描述：TODO <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年5月12日 下午5:42:34 <br>
     *
     * @return
     */
    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> propsMap = new HashMap<>();
        propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, configKafkaConsumer.getBootstrap_servers());
        propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, configKafkaConsumer.getEnable_auto_commit());
        propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, configKafkaConsumer.getAuto_commit_interval_ms());
        propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, configKafkaConsumer.getSession_timeout_ms());
        propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, configKafkaConsumer.getGroup_id());
        propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, configKafkaConsumer.getAuto_offset_reset());
        //propsMap.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 10000);
        propsMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 2);
        return propsMap;
    }
    /*@Bean
    public Map<String, Object> consumerSparkConfigs() {
        LoggerUtils.info(LOGGER, "读取到consumerConfigs配置:" + configKafkaConsumer.toString());
        Map<String, Object> propsMap = new HashMap<>();
        propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, configKafkaConsumer.getBootstrap_servers());
        propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, configKafkaConsumer.getEnable_auto_commit());
        propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, configKafkaConsumer.getAuto_commit_interval_ms());
        propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, configKafkaConsumer.getSession_timeout_ms());
        propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, configKafkaConsumer.getSpark_group_id());
        propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, configKafkaConsumer.getAuto_offset_reset());
        return propsMap;
    }*/

    /**
     * 方法：consumerFactory <br>
     * 描述：TODO <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年5月12日 下午5:42:32 <br>
     *
     * @return
     */
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }
    /*@Bean
    public ConsumerFactory<String, String> consumerSparkFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerSparkConfigs());
    }*/

    /**
     * 方法：listener <br>
     * 描述：监听 <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年5月12日 下午5:42:32 <br>
     * KafkaConsumerListener
     *
     * @return
     */
//    @Bean
//    public KafkaConsumerListener listener() {
//        return new KafkaConsumerListener();
//    }

}
