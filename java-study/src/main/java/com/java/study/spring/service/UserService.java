package com.java.study.spring.service;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author: cxz
 * @create: 2021/2/1 16:03
 * @description:
 **/
@Service
public class UserService implements FactoryBean<IndexService> {


    @Override
    public IndexService getObject() throws Exception {
        return new IndexService();
    }

    @Override
    public Class<?> getObjectType() {
        return IndexService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
