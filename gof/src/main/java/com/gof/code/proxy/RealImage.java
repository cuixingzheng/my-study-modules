package com.gof.code.proxy;

/**
 * @author: cxz
 * @create: 2020/8/11 16:27
 * @description:
 **/
public class RealImage implements Image {
    @Override
    public void display() {
        System.out.println("this is real image");
    }
}
