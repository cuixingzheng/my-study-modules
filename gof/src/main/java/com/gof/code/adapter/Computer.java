package com.gof.code.adapter;

/**
 * @author: cxz
 * @create: 2020/8/5 14:48
 * @description:
 **/
public class Computer {

    private ThreePower threePower;

    public Computer(ThreePower threePower) {
        this.threePower = threePower;
    }

    public void work(){
        System.out.println("computer 开始充电");
        threePower.supplyThreePower();
        System.out.println("computer 开始工作");
    }
}
