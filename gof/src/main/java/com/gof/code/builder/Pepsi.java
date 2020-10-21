package com.gof.code.builder;

/**
 * @author: cxz
 * @create: 2020/8/5 16:23
 * @description:
 **/
public class Pepsi extends ColdDrink {
    @Override
    public String getName() {
        return "Pepsi";
    }

    @Override
    public float getPrice() {
        return 10.5f;
    }
}
