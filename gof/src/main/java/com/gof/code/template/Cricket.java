package com.gof.code.template;

/**
 * @author: cxz
 * @create: 2020/8/13 14:09
 * @description:
 **/
public class Cricket extends Game {
    @Override
    void initGame() {
        System.out.println("init Cricket Game");
    }

    @Override
    void beginGame() {
        System.out.println("begin Cricket Game");
    }

    @Override
    void endGame() {
        System.out.println("end Cricket Game");
    }
}
