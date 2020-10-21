package com.springcloud2020.stream.consumer.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author: cxz
 * @create: 2020/10/20 15:03
 * @description:
 **/
public interface CustomSink {

    String CUSTOM_INPUT = "custom_input";

    @Input(CUSTOM_INPUT)
    SubscribableChannel input();
}
