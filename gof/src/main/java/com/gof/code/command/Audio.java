package com.gof.code.command;

/**
 * @author: cxz
 * @create: 2020/8/12 10:50
 * @description:
 **/
public class Audio implements Equipment {
    @Override
    public void onButton() {
        System.out.println("打开音响");
    }
    @Override
    public void offButton() {
        System.out.println("关闭音响");
    }
}
