package com.springcloud2020.stream.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Springcloud2020StreamProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud2020StreamProviderApplication.class, args);
    }

}
