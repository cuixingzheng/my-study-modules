package com.gof.code.command;

/**
 * @author: cxz
 * @create: 2020/8/12 10:48
 * @description:
 **/
public class Refrigerator implements Equipment {
    @Override
    public void onButton() {
        System.out.println("打开冰箱");
    }
    @Override
    public void offButton() {
        System.out.println("关闭冰箱");
    }
}
