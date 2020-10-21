package com.gof.code.memento;

/**
 * @author: cxz
 * @create: 2020/8/12 16:14
 * @description:
 **/
public class Originator {
    private String state;
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Memento saveToMemento(String state){
        return new Memento(state);
    }
    public void setStateByMemento(Memento memento){
        this.state = memento.getState();
    }
}
