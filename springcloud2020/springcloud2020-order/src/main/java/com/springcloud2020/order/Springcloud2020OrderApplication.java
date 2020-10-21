package com.springcloud2020.order;

import com.springcloud2020.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name= "SPRINGCLOUD2020-PAYMENT",configuration = MySelfRule.class)
@EnableFeignClients(basePackages = {"com.springcloud2020.payment.remote"})
//@EnableCircuitBreaker
@EnableHystrix
public class Springcloud2020OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springcloud2020OrderApplication.class, args);
    }
}
