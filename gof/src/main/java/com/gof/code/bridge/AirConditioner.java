package com.gof.code.bridge;

/**
 * @author: cxz
 * @create: 2020/8/7 10:17
 * @description:
 **/
public class AirConditioner implements Device {
    @Override
    public void work() {
        System.out.println("空调可以吹冷风");
    }
}
