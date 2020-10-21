package com.springcloud2020.config.client002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Springcloud2020ConfigClient002Application {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud2020ConfigClient002Application.class, args);
    }

}
