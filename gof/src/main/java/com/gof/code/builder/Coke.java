package com.gof.code.builder;

/**
 * @author: cxz
 * @create: 2020/8/5 16:23
 * @description:
 **/
public class Coke extends ColdDrink {
    @Override
    public String getName() {
        return "Coke";
    }

    @Override
    public float getPrice() {
        return 10f;
    }
}
