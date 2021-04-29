package com.java.study.spring.ss;

/**
 * @author: cxz
 * @create: 2021/3/2 15:06
 * @description:
 **/
public abstract class Animal {



    public Animal() {
        System.out.println("无参构造抽象类构造函数执行、、、、");
    }

    public Animal(String name) {
        System.out.println("有参构造抽象类构造函数执行、、、、");
    }


}
