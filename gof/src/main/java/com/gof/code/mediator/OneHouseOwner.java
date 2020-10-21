package com.gof.code.mediator;

/**
 * @author: cxz
 * @create: 2020/8/12 15:10
 * @description:
 **/
public class OneHouseOwner implements HouseOwner {
    @Override
    public void handler() {
        System.out.println("一居室便宜");
    }
}
