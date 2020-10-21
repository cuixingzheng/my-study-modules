package com.springcloud2020.feign.remote;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cxz
 * @create: 2020/9/30 17:17
 * @description:
 **/
@Component
@FeignClient("SPRINGCLOUD2020-PAYMENT")
public interface IPaymentController {

     @PostMapping(value = "payment/createPayment")
     Map<String,Object> createPayment();

}
