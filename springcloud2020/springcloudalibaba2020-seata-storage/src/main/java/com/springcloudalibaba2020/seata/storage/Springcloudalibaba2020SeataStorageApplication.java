package com.springcloudalibaba2020.seata.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springcloudalibaba2020.seata.storage.dao")
public class Springcloudalibaba2020SeataStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloudalibaba2020SeataStorageApplication.class, args);
    }

}
