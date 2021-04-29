package com.java.study.spring.ss;

/**
 * @author: cxz
 * @create: 2021/3/2 18:32
 * @description:
 **/
public class Water extends AbstractFood {

    @Override
    public void eat() {
        System.out.println("drink water");
    }

    public void eat1(){
        System.out.println("eat1 method");
    }
}
