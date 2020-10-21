package com.springcloud.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cxz
 * @create: 2020/9/27 18:07
 * @description:
 **/

@Controller
@RequestMapping("")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @RequestMapping("/getServerInfo")
    @ResponseBody
    public String getServerInfo() {
        // 通过eurekaClient访问服务器获取某个命名的集群。
        // getNextServerFromEureka的第一个参数是服务器名称，可重复
        // 因为获得的是下一个,所以是负载均衡的
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("SPRINGCLOUD-PROVIDER", false);
        System.out.println("name:" + nextServerFromEureka.getAppName() + " port:" + nextServerFromEureka.getPort());
        System.out.println("IPAddr:" + nextServerFromEureka.getIPAddr() + " port:" + nextServerFromEureka.getPort());
        return nextServerFromEureka.getAppName();
    }

    @PostMapping(value = "testEureka")
    @ResponseBody
    public String testEureka(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE + ";charset=utf-8");
        HttpEntity<String> entity = new HttpEntity<String>(null,headers);
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("SPRINGCLOUD-PROVIDER", false);
        String httpUrl = "http://" + nextServerFromEureka.getIPAddr() + ":" + nextServerFromEureka.getPort() + "/index";
        JSONObject result = restTemplate.postForObject(httpUrl, entity, JSONObject.class);
        System.out.println(result);
        return "my is consumer";
    }



}
