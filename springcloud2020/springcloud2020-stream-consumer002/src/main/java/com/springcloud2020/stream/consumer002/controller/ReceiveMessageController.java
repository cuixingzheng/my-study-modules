package com.springcloud2020.stream.consumer002.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author: cxz
 * @create: 2020/10/20 10:41
 * @description:
 **/
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> message){
        System.out.println("消息"+serverPort+"号接收消息: " + message.getPayload());
        //return "receive message success";
    }
}
