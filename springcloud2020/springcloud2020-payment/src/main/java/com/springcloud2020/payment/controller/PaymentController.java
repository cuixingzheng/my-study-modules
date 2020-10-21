package com.springcloud2020.payment.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "createPayment")
    @ResponseBody
    public Map<String,Object> createPayment(HttpServletRequest request){
        System.out.println("X-Request-red = " + request.getHeader("X-Request-red"));
        System.out.println("red = " + request.getParameter("red"));
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",200);
        result.put("msg","由支付微服务系统创建成功,serverPort : " + serverPort);
        return result;
    }

    @GetMapping("discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String s : services){
            System.out.println("******item :" + s);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("springcloud2020-payment");
        for (ServiceInstance instance : instances){
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "createPaymentHf")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "createPaymentHfException",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")}
    )
    public Map<String,Object> createPaymentHf(){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",400);
        result.put("msg","由支付微服务系统创建成功method : createPaymentHf,serverPort : " + serverPort);
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Map<String,Object> createPaymentHfException(){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",200);
        result.put("msg","由支付系统降级,serverPort : " + serverPort);
        return result;
    }

    @GetMapping(value = "createPaymentHf002")
    @ResponseBody
    public Map<String,Object> createPaymentHf002(){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",400);
        result.put("msg","由支付微服务系统创建成功method : createPaymentHf002,serverPort : " + serverPort);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "createPaymentHf003")
    @ResponseBody
    public Map<String,Object> createPaymentHf003(){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",400);
        result.put("msg","由支付微服务系统创建成功method : createPaymentHf003,serverPort : " + serverPort);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "createPaymentHf004/{id}")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "createPaymentHf004Exception",
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//打开熔断功能
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//规约请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//时间窗口期
    }
    )
    public Map<String,Object> createPaymentHf004(@PathVariable("id") Integer id){
        if(id < 0)
            throw new RuntimeException("id 不能为负数");
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",400);
        result.put("msg","由支付微服务系统创建成功method : createPaymentHf004,serverPort : " + serverPort);
        return result;
    }

    public Map<String,Object> createPaymentHf004Exception(Integer id){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",400);
        result.put("msg","支付微服务系统降级，id不能为负数。method : createPaymentHf004,serverPort : " + serverPort);
        return result;
    }

    @GetMapping(value = "createPaymentHf005/{id}")
    @ResponseBody
    public Map<String,Object> createPaymentHf005(@PathVariable("id") Integer id){
        if(id < 0)
            throw new RuntimeException("id 不能为负数");
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",400);
        result.put("msg","由支付微服务系统创建成功method : createPaymentHf005,serverPort : " + serverPort);
        return result;
    }



}
