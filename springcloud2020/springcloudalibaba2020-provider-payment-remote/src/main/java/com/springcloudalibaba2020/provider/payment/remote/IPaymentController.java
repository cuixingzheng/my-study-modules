package com.springcloudalibaba2020.provider.payment.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: cxz
 * @create: 2020/9/30 17:17
 * @description:
 **/
@FeignClient(value = "alibaba-provider-payment",fallback = PaymentControllerImpl.class ) // 使用FeignClient注解，并配置注册中心当中的服务
//@FeignClient(value = "alibaba-provider-payment") // 使用FeignClient注解，并配置注册中心当中的服务
public interface IPaymentController {

     @GetMapping(value = "payment/createPayment") //声明一个与提供者一致的服务api路径
     String createPayment();
}
