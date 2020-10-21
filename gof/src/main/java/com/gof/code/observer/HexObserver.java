package com.gof.code.observer;

/**
 * @author: cxz
 * @create: 2020/8/12 17:43
 * @description:
 **/
public class HexObserver implements Observer {
    @Override
    public void update(int state) {
        System.out.println("hex : " + Integer.toHexString(state));
    }
}
