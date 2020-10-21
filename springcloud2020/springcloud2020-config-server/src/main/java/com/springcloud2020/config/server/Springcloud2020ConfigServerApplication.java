package com.springcloud2020.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class Springcloud2020ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud2020ConfigServerApplication.class, args);
    }

}
