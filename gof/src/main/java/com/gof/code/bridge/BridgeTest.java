package com.gof.code.bridge;

/**
 * @author: cxz
 * @create: 2020/8/7 10:28
 * @description:
 **/
public class BridgeTest {

    public static void main(String[] args) {
        //创建一个格力空调
        Brand greeAC = new Gree(new AirConditioner());
        //创建一个格力冰箱
        Brand greeRF = new Gree(new Refrigerator());
        //创建一个海尔空调
        Brand haierAC = new Haier(new AirConditioner());
        //创建一个海尔冰箱
        Brand haierRF = new Haier(new Refrigerator());

        greeAC.work();
        greeRF.work();
        haierAC.work();
        haierRF.work();
    }
}
