package com.gof.code.nullobject;

/**
 * @author: cxz
 * @create: 2020/8/13 16:24
 * @description:
 **/
public class NullBook implements Book{
    private String name;
    public NullBook(String name) {
        this.name = name;
    }
    @Override
    public boolean isNull() {
        return false;
    }
    @Override
    public void show() {
        System.out.println("sorry , this book " + name + " does not exist");
    }
}
