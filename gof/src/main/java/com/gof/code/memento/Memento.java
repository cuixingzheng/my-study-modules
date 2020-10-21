package com.gof.code.memento;

/**
 * @author: cxz
 * @create: 2020/8/12 16:13
 * @description:
 **/
public class Memento {
    private String state;
    public Memento(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}
