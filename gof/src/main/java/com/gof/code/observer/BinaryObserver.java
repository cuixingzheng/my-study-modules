package com.gof.code.observer;

/**
 * @author: cxz
 * @create: 2020/8/12 17:45
 * @description:
 **/
public class BinaryObserver implements  Observer {
    @Override
    public void update(int state) {
        System.out.println("binary :" + Integer.toBinaryString(state));
    }
}
