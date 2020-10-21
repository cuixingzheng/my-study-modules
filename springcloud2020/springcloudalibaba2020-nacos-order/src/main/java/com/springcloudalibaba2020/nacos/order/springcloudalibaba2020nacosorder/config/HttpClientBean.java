package com.springcloudalibaba2020.nacos.order.springcloudalibaba2020nacosorder.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: cxz
 * @create: 2020/9/29 14:14
 * @description:
 **/
@Configuration
public class HttpClientBean {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
