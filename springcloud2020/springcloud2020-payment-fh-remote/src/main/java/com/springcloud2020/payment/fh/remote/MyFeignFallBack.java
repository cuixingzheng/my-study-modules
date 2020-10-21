package com.springcloud2020.payment.fh.remote;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cxz
 * @create: 2020/10/13 11:38
 * @description:
 **/
@Component
public class MyFeignFallBack implements IPaymentController {
    public Map<String, Object> createPayment() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",200);
        map.put("msg","MyFeignFallBack降级,method : createPayment" );
        return map;
    }

    public Map<String, Object> createPaymentHf() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",200);
        map.put("msg","MyFeignFallBack降级,method : createPaymentHf");
        return map;
    }

    public Map<String, Object> createPaymentHf002() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",200);
        map.put("msg","MyFeignFallBack降级,method : createPaymentHf002");
        return map;
    }

    public Map<String, Object> createPaymentHf003() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",200);
        map.put("msg","MyFeignFallBack降级,method : createPaymentHf003");
        return map;
    }

    public Map<String, Object> createPaymentHf004(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",200);
        map.put("msg","MyFeignFallBack降级,method : createPaymentHf004");
        return map;
    }

    public Map<String, Object> createPaymentHf005(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",200);
        map.put("msg","MyFeignFallBack降级,method : createPaymentHf005");
        return map;
    }
}
