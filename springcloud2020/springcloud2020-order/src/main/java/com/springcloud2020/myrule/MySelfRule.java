package com.springcloud2020.myrule;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: cxz
 * @create: 2020/9/30 15:20
 * @description:
 **/
@Configuration
public class MySelfRule {

    @Bean
    public RandomRule myRandomRule(){
        return new RandomRule();
    }
}
