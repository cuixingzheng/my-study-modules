package com.springcloudalibaba2020.consumer.order.controller;

import com.springcloudalibaba2020.provider.payment.remote.IPaymentController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: cxz
 * @create: 2020/10/28 14:06
 * @description:
 **/
@RestController
@RequestMapping("consumer")
public class ConsumerUseOpenFeignController {
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private IPaymentController iPaymentController;

    @GetMapping("consumerUseOpenFeignData")
    @ResponseBody
    public String consumerUseOpenFeignData(){
        return iPaymentController.createPayment();
    }


    @GetMapping("consumerUseOpenFeignData002")
    @ResponseBody
    public String consumerUseOpenFeignData002(){
        return "consumerUseOpenFeignData002 执行成功，port : " + serverPort;
    }

}
