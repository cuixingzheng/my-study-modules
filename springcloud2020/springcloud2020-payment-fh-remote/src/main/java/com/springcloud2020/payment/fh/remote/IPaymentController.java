package com.springcloud2020.payment.fh.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * @author: cxz
 * @create: 2020/9/30 17:17
 * @description:
 **/
@FeignClient(value = "SPRINGCLOUD2020-PAYMENT",fallback = MyFeignFallBack.class ) // 使用FeignClient注解，并配置注册中心当中的服务
//@FeignClient(value = "SPRINGCLOUD2020-PAYMENT") // 使用FeignClient注解，并配置注册中心当中的服务
public interface IPaymentController {

     @PostMapping(value = "payment/createPayment") //声明一个与提供者一致的服务api路径
     Map<String,Object> createPayment();

     @GetMapping(value = "payment/createPaymentHf")
     Map<String,Object> createPaymentHf();

     @GetMapping(value = "payment/createPaymentHf002")
     Map<String,Object> createPaymentHf002();

     @GetMapping(value = "payment/createPaymentHf003")
     Map<String,Object> createPaymentHf003();

     @GetMapping(value = "payment/createPaymentHf004/{id}")
     Map<String,Object> createPaymentHf004(@PathVariable("id")Integer id);

     @GetMapping(value = "payment/createPaymentHf005/{id}")
     Map<String,Object> createPaymentHf005(@PathVariable("id") Integer id);
}
