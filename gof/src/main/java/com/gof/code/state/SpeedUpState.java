package com.gof.code.state;

/**
 * @author: cxz
 * @create: 2020/8/13 10:50
 * @description:
 **/
public class SpeedUpState implements State {
    @Override
    public void handle(Hero hero) {
        hero.setState(this);
    }

    @Override
    public String toString() {
        return "加速状态";
    }
}
