package com.kafka.test.demo.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类名称：KafkaListener <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2017年5月12日 下午5:45:31 <br>
 * 修改备注：TODO <br>
 */
@Component
public class KafkaVideoConsumerListener {
//    @KafkaListener(topics = {"ai_errorVideoDataTemp"}, containerFactory = "kafkaListenerContainerFactory")
//    public void consumerVideoErrorData(ConsumerRecord<?, ?> record, Acknowledgment ack) {
//        //consumerErrorEnd(record, ack);
//        System.out.println(record.value());
//    }


    @KafkaListener(topics = {"ai_errorVideoDataTemp"}, containerFactory = "kafkaListenerContainerFactory")
    public void consumerVideoErrorData(List<ConsumerRecord<?, ?>> records, Acknowledgment ack, Consumer consumer) {
        //consumerErrorEnd(record, ack);
        System.out.println(records.size());
        for(ConsumerRecord c : records){
            System.out.println(c.value());
        }
        System.out.println(consumer);
        ack.acknowledge();
    }

}
