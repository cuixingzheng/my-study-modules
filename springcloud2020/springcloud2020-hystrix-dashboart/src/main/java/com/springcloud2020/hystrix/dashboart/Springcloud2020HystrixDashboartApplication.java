package com.springcloud2020.hystrix.dashboart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class Springcloud2020HystrixDashboartApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud2020HystrixDashboartApplication.class, args);
    }

}
