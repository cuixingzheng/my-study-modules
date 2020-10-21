package com.springcloud2020.feign.controller;

import com.springcloud2020.feign.remote.IPaymentController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @PostMapping(value = "createOrder")
    public Map<String,Object> createOrder(){

        return iPaymentController.createPayment();
    }

}
