package com.gof.code.state;

/**
 * @author: cxz
 * @create: 2020/8/13 10:52
 * @description:
 **/
public class SpeedDownState implements State {
    @Override
    public void handle(Hero hero) {
        hero.setState(this);
    }
    @Override
    public String toString() {
        return "减速状态";
    }
}
