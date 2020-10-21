package com.gof.code.builder;

/**
 * @author: cxz
 * @create: 2020/8/5 16:21
 * @description:
 **/
public class VegBurger extends Burger {
    @Override
    public String getName() {
        return "VegBurger";
    }

    @Override
    public float getPrice() {
        return 20f;
    }
}
