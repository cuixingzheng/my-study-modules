package com.gof.code.factory;

/**
 * @author: cxz
 * @create: 2020/8/4 18:57
 * @description:
 **/
public class MobileTest {

    public static void main(String[] args) {
        Mobile iphone = MobileFactory.createMobile("苹果");
        iphone.show();
        System.out.println("==========");
        Mobile samsung = MobileFactory.createMobile("三星");
        samsung.show();

    }
}
