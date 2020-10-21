package com.gof.code.observer;

/**
 * @author: cxz
 * @create: 2020/8/12 17:44
 * @description:
 **/
public class OctalObserver implements Observer {
    @Override
    public void update(int state) {
        System.out.println("Octal : " + Integer.toOctalString(state));
    }
}
