package com.springcloud2020.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Springcloud2020GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud2020GatewayApplication.class, args);
    }

}
