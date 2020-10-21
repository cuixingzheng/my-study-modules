package com.springcloud2020.payment002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class Springcloud2020Payment002Application {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud2020Payment002Application.class, args);
    }

}
