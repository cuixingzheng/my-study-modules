package com.gof.code.mediator;

/**
 * @author: cxz
 * @create: 2020/8/12 15:11
 * @description:
 **/
public class TwoHouseOwner implements HouseOwner {
    @Override
    public void handler() {
        System.out.println("两居室合适，靠谱");
    }
}
