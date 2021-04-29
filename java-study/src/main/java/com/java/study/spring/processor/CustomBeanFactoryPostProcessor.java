package com.java.study.spring.processor;

import com.java.study.spring.service.IndexService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author: cxz
 * @create: 2021/2/1 16:27
 * @description:
 **/
//@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        GenericBeanDefinition userService = (GenericBeanDefinition) configurableListableBeanFactory.getBeanDefinition("userService");
        userService.setBeanClass(IndexService.class);

    }
}
