package com.gof.code.template;

/**
 * @author: cxz
 * @create: 2020/8/13 14:10
 * @description:
 **/
public class Football extends Game {
    @Override
    void initGame() {
        System.out.println("init Football Game");
    }

    @Override
    void beginGame() {
        System.out.println("begin Football Game");
    }

    @Override
    void endGame() {
        System.out.println("end Football Game");
    }
}
