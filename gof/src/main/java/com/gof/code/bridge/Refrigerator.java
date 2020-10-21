package com.gof.code.bridge;

/**
 * @author: cxz
 * @create: 2020/8/7 10:15
 * @description:
 **/
public class Refrigerator implements Device{
    @Override
    public void work() {
        //这里实现具体功能
        System.out.println("冰箱可以储藏食物");
    }
}
