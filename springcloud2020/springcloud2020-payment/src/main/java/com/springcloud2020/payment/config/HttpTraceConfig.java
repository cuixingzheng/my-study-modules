package com.springcloud2020.payment.config;

import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: cxz
 * @create: 2020/9/29 17:30
 * @description:
 **/
@Configuration
public class HttpTraceConfig {

    @Bean
    public InMemoryHttpTraceRepository getInMemoryHttpTraceRepository(){
        return new InMemoryHttpTraceRepository();
    }
}
