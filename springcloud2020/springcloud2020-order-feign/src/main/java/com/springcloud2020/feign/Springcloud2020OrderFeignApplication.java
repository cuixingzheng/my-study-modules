package com.springcloud2020.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Springcloud2020OrderFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springcloud2020OrderFeignApplication.class, args);
    }
}
