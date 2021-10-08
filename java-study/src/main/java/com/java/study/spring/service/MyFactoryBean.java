package com.java.study.spring.service;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author: cxz
 * @create: 2021/6/23 20:24
 * @description:
 **/
@Component
public class MyFactoryBean implements FactoryBean<SaleService> {

    public void myFactoryBeanHandler(){
        System.out.println("myFactoryBeanHandler ....");
    }


    @Override
    public SaleService getObject() throws Exception {
        return new SaleService();
    }

    @Override
    public Class<?> getObjectType() {
        return SaleService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
