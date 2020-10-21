package com.gof.code.mediator;

/**
 * @author: cxz
 * @create: 2020/8/12 15:12
 * @description:
 **/
public class ThreeHouseOwner implements HouseOwner{
    @Override
    public void handler() {
        System.out.println("三居室宽松");
    }
}
