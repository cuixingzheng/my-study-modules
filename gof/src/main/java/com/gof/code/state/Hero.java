package com.gof.code.state;

/**
 * @author: cxz
 * @create: 2020/8/13 10:48
 * @description:
 **/
public class Hero {

    private State state;

    public Hero(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
