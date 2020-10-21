package com.gof.code.nullobject;

/**
 * @author: cxz
 * @create: 2020/8/13 16:21
 * @description:
 **/
public class RealBook implements Book {
    private String name;
    public RealBook(String name) {
        this.name = name;
    }
    @Override
    public boolean isNull() {
        return false;
    }
    @Override
    public void show() {
        System.out.println("book name is " + name);
    }
}
