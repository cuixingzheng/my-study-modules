package com.gof.code.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: cxz
 * @create: 2020/8/12 16:16
 * @description:
 **/
public class CareTaker {
    private List<Memento> mementos = new ArrayList<>();
    public void addMemento(Memento memento){
        mementos.add(memento);
    }
    public Memento getMemento(int index){
        return mementos.get(index);
    }
}
