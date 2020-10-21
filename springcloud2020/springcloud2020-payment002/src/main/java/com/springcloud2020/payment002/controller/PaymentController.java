package com.springcloud2020.payment002.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: cxz
 * @create: 2020/9/29 13:34
 * @description:
 **/
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "createPayment")
    @ResponseBody
    public Map<String,Object> createPayment(){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",200);
        result.put("msg","由支付微服务系统创建成功,serverPort : " + serverPort);
        return result;
    }

    @GetMapping(value = "createPaymentHf")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "createPaymentHfException",
    commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")}
    )
    public Map<String,Object> createPaymentHf(){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",400);
        result.put("msg","由支付微服务系统创建成功method : createPaymentHf,serverPort : " + serverPort);
        return result;
    }


    public Map<String,Object> createPaymentHfException(){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",200);
        result.put("msg","由支付系统降级,serverPort : " + serverPort);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

}
