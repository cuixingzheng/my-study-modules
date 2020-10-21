package com.springcloud2020.stream.provider.service.impl;

import com.springcloud2020.stream.provider.service.ISendMessageService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author: cxz
 * @create: 2020/10/19 17:52
 * @description:
// **/
@EnableBinding(Source.class)//定义消息推送管道
public class SendMessageServiceImpl implements ISendMessageService {

    @Resource(name = Source.OUTPUT)
    private MessageChannel messageChannel;//消息发送管道，对消息进行封装

    public String sendMessage() {
        String message = UUID.randomUUID().toString();
        System.out.println("******message : " + message);
        messageChannel.send(MessageBuilder.withPayload(message).build());
        return "success";
    }
}
