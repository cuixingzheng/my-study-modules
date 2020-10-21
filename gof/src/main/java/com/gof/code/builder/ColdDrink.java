package com.gof.code.builder;

/**
 * @author: cxz
 * @create: 2020/8/5 16:20
 * @description:
 **/
public abstract class ColdDrink implements Item {
    @Override
    public Packing getPacking() {
        return new Bottle();
    }
}
