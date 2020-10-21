package com.gof.code.builder;

/**
 * @author: cxz
 * @create: 2020/8/5 16:22
 * @description:
 **/
public class ChickenBurger extends Burger {
    @Override
    public String getName() {
        return "ChickenBurger";
    }

    @Override
    public float getPrice() {
        return 23f;
    }
}
