package com.springcloud2020.feign.controller;

import com.springcloud2020.feign.config.ILoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author: cxz
 * @create: 2020/9/29 14:13
 * @description:
 **/
@RestController
@RequestMapping("order")
public class OrderController {

    public static final String URL = "http://SPRINGCLOUD2020-PAYMENT";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ILoadBalance iLoadBalance;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "createOrder")
    public Map<String,Object> createOrder(){
        return restTemplate.postForObject(URL+ "/payment/createPayment", null, Map.class);
    }

    @PostMapping(value = "createOrderSelfRandom")
    public Map<String,Object> createOrderSelfRandom(){
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD2020-PAYMENT");
        ServiceInstance instance = iLoadBalance.getServiceInstance(instances);
        System.out.println("instance : " + instance.getUri());
        return restTemplate.postForObject(instance.getUri() + "/payment/createPayment", null, Map.class);
    }
}
