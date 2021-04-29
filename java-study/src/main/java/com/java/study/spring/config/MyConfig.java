package com.java.study.spring.config;

import com.java.study.spring.service.IndexService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: cxz
 * @create: 2021/2/18 15:08
 * @description:
 **/
//@Configuration
public class MyConfig {

    @Bean("indexService2")
    public IndexService getIndexService(){
        IndexService indexService = new IndexService();
        return indexService;
    }



}
