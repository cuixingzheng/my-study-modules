package com.springcloudalibaba2020.seata.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springcloudalibaba2020.seata.account.dao")
public class Springcloudalibaba2020SeataAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloudalibaba2020SeataAccountApplication.class, args);
    }

}
