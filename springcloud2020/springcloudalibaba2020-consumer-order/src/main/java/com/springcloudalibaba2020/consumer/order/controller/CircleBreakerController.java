package com.springcloudalibaba2020.consumer.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: cxz
 * @create: 2020/10/27 16:12
 * @description:
 **/
@RestController
@RequestMapping("order")
public class CircleBreakerController {

    public static final String URL = "http://alibaba-provider-payment";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("getInfoData/{id}")
    //@SentinelResource(value = "getInfoData",fallback = "handleFallBack",blockHandler = "handleBlockException")
    public String getInfoData(@PathVariable("id")Integer id){
        if(id == 4){
            throw new IllegalArgumentException("id 非法参数异常");
        }else if(id >0 && id <=3){
            return restTemplate.getForObject(URL + "/payment/createPayment",String.class);
        }else {
            throw new NullPointerException("id 获取数据空指针异常");
        }
    }

    public String handleFallBack(@PathVariable("id")Integer id,Throwable  e){
        return "由handleFallBack作为兜底处理，exception内容为： " + e.getMessage();
    }

    public String handleBlockException(@PathVariable("id")Integer id,BlockException  e){
        return "由handleBlockException作为熔断降级服务，exception内容为： " + e.getMessage();
    }
}
