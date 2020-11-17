package com.springcloudalibaba2020.consumer.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = {"com.springcloudalibaba2020.provider.payment.remote","com.springcloudalibaba2020.consumer.order"})
@EnableFeignClients(basePackages = {"com.springcloudalibaba2020.provider.payment.remote"})
public class Springcloudalibaba2020ConsumerOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springcloudalibaba2020ConsumerOrderApplication.class, args);
    }
}
