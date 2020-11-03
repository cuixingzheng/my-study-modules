package com.springcloudalibaba2020.provider.payment.remote;

import org.springframework.stereotype.Component;

/**
 * @author: cxz
 * @create: 2020/10/28 14:13
 * @description:
 **/
@Component
public class PaymentControllerImpl implements IPaymentController {
    public String createPayment() {
        return "使用sentinel进入降级方法";
    }
}
