package com.springcloudalibaba2020.nacos.order.springcloudalibaba2020nacosorder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: cxz
 * @create: 2020/10/21 10:06
 * @description:
 **/
@RestController
@RequestMapping("order")
public class NacosOrderController {

    public static final String SERVER_URL = "http://nacos-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("executeOrder")
    public String executeOrder(){
        return restTemplate.getForObject(SERVER_URL + "/payment/executePayment",String.class);
    }

}
