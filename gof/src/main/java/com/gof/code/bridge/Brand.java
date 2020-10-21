package com.gof.code.bridge;

/**
 * @author: cxz
 * @create: 2020/8/7 10:09
 * @description:
 **/
public abstract class Brand {

    private String name;

    //这是桥接关键，将具体工作设备独立实现
    private Device device;
    //需要有个构造方法将device初始化
    public Brand(Device device) {
        this.device = device;
    }

    public void work(){
        System.out.println("品牌：" + name);
        //具体共有由Device工作
        device.work();
        System.out.println();
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
