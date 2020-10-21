package com.gof.code.state;

/**
 * @author: cxz
 * @create: 2020/8/13 11:00
 * @description:
 **/
public class CommonState implements State{
    @Override
    public void handle(Hero hero) {
        hero.setState(this);
    }
    @Override
    public String toString() {
        return "正常状态";
    }
}
