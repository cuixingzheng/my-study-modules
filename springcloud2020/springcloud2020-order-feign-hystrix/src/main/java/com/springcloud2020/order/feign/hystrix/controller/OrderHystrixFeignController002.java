package com.springcloud2020.order.feign.hystrix.controller;

import com.springcloud2020.payment.fh.remote.IPaymentController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("hystrixFeign")
public class OrderHystrixFeignController002 {


    @Resource
    private IPaymentController iPaymentController;

    @GetMapping(value = "createOrderHf003")
    public Map<String,Object> createOrderHf003(){
        return iPaymentController.createPaymentHf003();
    }

    @GetMapping(value = "createOrderHf004/{id}")
    public Map<String,Object> createOrderHf004(@PathVariable("id") Integer id){
        return iPaymentController.createPaymentHf004(id);
    }

    @GetMapping(value = "createOrderHf005/{id}")
    public Map<String,Object> createOrderHf005(@PathVariable("id") Integer id){
        return iPaymentController.createPaymentHf005(id);
    }


}
