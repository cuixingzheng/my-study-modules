package com.springcloud2020.stream.consumer002.controller;

import com.springcloud2020.stream.consumer002.service.CustomSink;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author: cxz
 * @create: 2020/10/20 10:41
 * @description:
 **/
@Component
@EnableBinding(CustomSink.class)
public class CustomReceiveMessageController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(CustomSink.CUSTOM_INPUT)
    public void receiveMessage(Message<String> message){
        System.out.println("****CUSTOM_INPUT******消息"+serverPort+"号接收消息: " + message.getPayload());
        //return "receive message success";
    }
}
