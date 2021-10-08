package com.java.study.spring;

import com.java.study.spring.config.AppConfig;
import com.java.study.spring.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: cxz
 * @create: 2021/2/1 15:08
 * @description:
 **/
public class TestSpring {



    public static void main(String[] args) {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //OrderService bean = ac.getBean(OrderService.class);
        //System.out.println(bean.getClass());
        SaleService saleService = ac.getBean(SaleService.class);
        ac.start();

        saleService.sale();
        MyFactoryBean myFactoryBean = ac.getBean(MyFactoryBean.class);
        myFactoryBean.myFactoryBeanHandler();

        MyFactoryBean myFactoryBean002 = (MyFactoryBean) ac.getBean("&myFactoryBean");
        myFactoryBean002.myFactoryBeanHandler();

        SaleService myFactoryBean003 = (SaleService) ac.getBean("myFactoryBean");
        myFactoryBean003.sale();

//        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//        for (String name : beanDefinitionNames) {
//            System.out.println(name);
//        }




        //ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:app.xml");
//        System.out.println(ac);
//        UserService userService = ac.getBean(UserService.class);
//        Object bean1 = ac.getBean("userService");
//        Object bean2 = ac.getBean("&userService");
//        System.out.println(userService.getClass());
//        System.out.println(bean1.getClass());
//        System.out.println(bean2.getClass());
        //System.out.println(userService);
//        System.out.println("======");


//        IndexService indexService = ac.getBean(IndexService.class);
//        System.out.println(indexService);

    }
}
