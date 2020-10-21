package com.springcloud2020.stream.consumer002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Springcloud2020StreamConsumer002Application {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud2020StreamConsumer002Application.class, args);
    }

}
