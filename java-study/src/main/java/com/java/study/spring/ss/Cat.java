package com.java.study.spring.ss;

/**
 * @author: cxz
 * @create: 2021/3/2 15:08
 * @description:
 **/
public class Cat extends Animal {

    private String name;

    public Cat() {
       // super("cate  001");
        System.out.println("创建cat...");
    }

    public Cat(String name) {
        System.out.println("创建cat...");
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
