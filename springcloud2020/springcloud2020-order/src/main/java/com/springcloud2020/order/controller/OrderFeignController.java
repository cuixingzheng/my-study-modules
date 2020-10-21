package com.springcloud2020.order.controller;

import com.springcloud2020.order.config.ILoadBalance;
import com.springcloud2020.payment.remote.IPaymentController;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("orderFeign")
public class OrderFeignController {

    @Resource
    private IPaymentController iPaymentController;

    @GetMapping(value = "createOrder")
    public Map<String,Object> createOrder(){
        return iPaymentController.createPayment();
    }
}
