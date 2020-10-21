package com.springcloud2020.stream.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Springcloud2020StreamConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud2020StreamConsumerApplication.class, args);
    }

}
