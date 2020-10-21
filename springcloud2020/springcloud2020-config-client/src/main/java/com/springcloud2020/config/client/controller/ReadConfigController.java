package com.springcloud2020.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: cxz
 * @create: 2020/10/16 14:35
 * @description:
 **/
@RestController
@RefreshScope
public class ReadConfigController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("getConfigInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
