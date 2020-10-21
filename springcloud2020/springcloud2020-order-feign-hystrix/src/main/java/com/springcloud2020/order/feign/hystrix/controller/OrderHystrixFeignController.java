package com.springcloud2020.order.feign.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud2020.payment.fh.remote.IPaymentController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: cxz
 * @create: 2020/9/29 14:13
 * @description:
 **/
@RestController
@RequestMapping("hystrixFeign")
@DefaultProperties(defaultFallback = "globalOrderHfTimeout",
commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")}
)
public class OrderHystrixFeignController {


    @Resource
    private IPaymentController iPaymentController;

    @GetMapping(value = "createOrderHf")
    @HystrixCommand(
            fallbackMethod = "createOrderHfTimeout",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
            })
    public Map<String,Object> createOrderHf(){
        return iPaymentController.createPaymentHf();
    }

    @GetMapping(value = "createOrderHf002")
    @HystrixCommand
    public Map<String,Object> createOrderHf002(){
        return iPaymentController.createPaymentHf002();
    }

    public Map<String,Object> createOrderHfTimeout(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",200);
        map.put("msg","订单系统服务降级");
        return map;
    }

    public Map<String,Object> globalOrderHfTimeout(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",200);
        map.put("msg","订单系统全局通用服务降级");
        return map;
    }

}
