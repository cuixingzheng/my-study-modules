package com.gof.code.decorator;

/**
 * @author: cxz
 * @create: 2020/8/11 11:54
 * @description:
 **/
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("this can draw rectangle");
    }
}
