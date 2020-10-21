package com.springcloud2020.payment.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cxz
 * @create: 2020/9/30 17:17
 * @description:
 **/
//@Component
@FeignClient("SPRINGCLOUD2020-PAYMENT") // 使用FeignClient注解，并配置注册中心当中的服务
public interface IPaymentController {

     @PostMapping(value = "payment/createPayment") //声明一个与提供者一致的服务api路径
     Map<String,Object> createPayment();
}
