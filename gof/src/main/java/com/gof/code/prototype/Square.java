package com.gof.code.prototype;

/**
 * @author: cxz
 * @create: 2020/8/5 17:29
 * @description:
 **/
public class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("this is square");
    }


    @Override
    public String toString() {
        return "Square{id = "+getId()+",name = "+getName()+"}";
    }
}
