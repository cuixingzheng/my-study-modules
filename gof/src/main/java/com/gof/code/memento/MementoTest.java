package com.gof.code.memento;

/**
 * @author: cxz
 * @create: 2020/8/12 16:22
 * @description:
 **/
public class MementoTest {

    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("state001");
        careTaker.addMemento(originator.saveToMemento(originator.getState()));
        originator.setState("state002");
        careTaker.addMemento(originator.saveToMemento(originator.getState()));
        originator.setState("state003");

        System.out.println("current state" + originator.getState());
        originator.setStateByMemento(careTaker.getMemento(0)); ;
        System.out.println("first state" + originator.getState());
        originator.setStateByMemento(careTaker.getMemento(1));
        System.out.println("second state" + originator.getState());
    }
}
