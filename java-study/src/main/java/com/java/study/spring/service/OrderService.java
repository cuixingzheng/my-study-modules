package com.java.study.spring.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: cxz
 * @create: 2021/3/5 16:46
 * @description:
 **/
@Service
public class OrderService implements DisposableBean {

    @PostConstruct
    public void init(){
        System.out.println("自定义初始化方法");
    }


    @PreDestroy
    public void destroy002(){
        System.out.println("destroy002");
    }

    public void destroy(){
        System.out.println("自定义销毁方法");
    }
}
