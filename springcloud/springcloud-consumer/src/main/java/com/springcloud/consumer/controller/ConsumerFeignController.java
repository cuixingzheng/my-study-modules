package com.springcloud.consumer.controller;

//import com.springcloud.provider.remote.IProviderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: cxz
 * @create: 2020/9/28 17:24
 * @description:
 **/
@Component
@RequestMapping("consumer")
public class ConsumerFeignController {

//    @Autowired
//    private IProviderFeignClient iProviderFeignClient;
//
//    @PostMapping("testFeign")
//    @ResponseBody
//    public String testFeign(){
//        return iProviderFeignClient.getProviderInfo();
//    }

}
