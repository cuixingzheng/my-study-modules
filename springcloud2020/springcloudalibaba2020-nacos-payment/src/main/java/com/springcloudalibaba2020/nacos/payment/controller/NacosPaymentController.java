package com.springcloudalibaba2020.nacos.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: cxz
 * @create: 2020/10/20 18:56
 * @description:
 **/
@RestController
@RequestMapping("payment")
public class NacosPaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "executePayment")
    private String executePayment(){
        return "提供者执行方法： executePayment，" + "server port : " + serverPort;
    }
}
