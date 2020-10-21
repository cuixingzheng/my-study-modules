package com.gof.code.builder;

/**
 * @author: cxz
 * @create: 2020/8/5 16:19
 * @description:
 **/
public abstract class Burger implements Item {
    @Override
    public Packing getPacking() {
        return new Wrapper();
    }
}
