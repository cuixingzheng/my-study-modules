package com.gof.code.state;

/**
 * @author: cxz
 * @create: 2020/8/13 10:53
 * @description:
 **/
public class SwimState implements State {
    @Override
    public void handle(Hero hero) {
        hero.setState(this);
    }
    @Override
    public String toString() {
        return "眩晕状态";
    }
}
