package com.gof.code.template;

/**
 * @author: cxz
 * @create: 2020/8/13 14:07
 * @description:
 **/
public abstract class Game {
    final void play(){
        initGame();
        beginGame();
        endGame();
    }
    abstract void initGame();
    abstract void beginGame();
    abstract void endGame();
}
