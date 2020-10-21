package com.gof.code.command;

/**
 * @author: cxz
 * @create: 2020/8/12 10:52
 * @description:
 **/
public class AirConditioner implements Equipment {
    @Override
    public void onButton() {
        System.out.println("打开空调");
    }
    @Override
    public void offButton() {
        System.out.println("关闭空调");
    }
}
