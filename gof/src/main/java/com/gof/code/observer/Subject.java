package com.gof.code.observer;

import java.util.Vector;

/**
 * @author: cxz
 * @create: 2020/8/12 17:35
 * @description:
 **/
public class Subject {
    private int state;
    private Vector<Observer> observers =  new Vector<>();
    public void attach(Observer observer){
        observers.add(observer);
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
        notifyAllObserver(state);
    }
    public void notifyAllObserver(int state){
        for (Observer observer : observers)
            observer.update(state);
    }
}
