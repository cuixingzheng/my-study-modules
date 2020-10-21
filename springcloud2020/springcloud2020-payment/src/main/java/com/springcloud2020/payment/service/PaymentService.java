package com.springcloud2020.payment.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: cxz
 * @create: 2020/10/12 16:37
 * @description:
 **/
@Service
public class PaymentService {
//
//    @Value("${server.port}")
//    private String serverPort;
//
//    @HystrixCommand(fallbackMethod = "createPaymentHfException",
//            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")}
//    )
//    public Map<String,Object> createPaymentHf(){
//        Map<String,Object> result = new HashMap<String, Object>();
//        result.put("code",400);
//        result.put("msg","由支付微服务系统创建成功method : createPaymentHf,serverPort : " + serverPort);
//        try {
//            TimeUnit.SECONDS.sleep(4);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public Map<String,Object> createPaymentHfException(){
//        Map<String,Object> result = new HashMap<String, Object>();
//        result.put("code",200);
//        result.put("msg","由支付系统降级,serverPort : " + serverPort);
//        return result;
//    }
}
