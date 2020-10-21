package com.springcloud2020.stream.provider.controller;

import com.springcloud2020.stream.provider.service.ICustomSendMessageService;
import com.springcloud2020.stream.provider.service.ISendMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: cxz
 * @create: 2020/10/19 18:05
 * @description:
 **/
@RestController
public class SendMessageController {

    @Resource
    private ISendMessageService iSendMessageService ;

    @Resource
    private ICustomSendMessageService iCustomSendMessageService;

    @GetMapping("sendMessage")
    public String sendMessage(){
        return iSendMessageService.sendMessage();
    }

    @GetMapping("customSendMessage")
    public String customSendMessage(){
        return iCustomSendMessageService.sendMessage();
    }
}
