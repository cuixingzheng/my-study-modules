package com.springcloud2020.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Springcloud2020ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud2020ConfigClientApplication.class, args);
    }

}
