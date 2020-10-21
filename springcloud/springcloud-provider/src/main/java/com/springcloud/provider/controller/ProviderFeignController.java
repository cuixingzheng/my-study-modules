package com.springcloud.provider.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: cxz
 * @create: 2020/9/28 17:16
 * @description:
 **/
@Controller
@RequestMapping("provider")
public class ProviderFeignController {

    @PostMapping("myProviderInfo")
    @ResponseBody
    public String myProviderInfo(){
        return "my is provider feign info";
    }
}
