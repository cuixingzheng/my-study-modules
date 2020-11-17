package com.springcloudalibaba2020.seata.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.springcloudalibaba2020.seata.order.dao")
@EnableFeignClients
public class Springcloudalibaba2020SeataOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloudalibaba2020SeataOrderApplication.class, args);
    }

}
