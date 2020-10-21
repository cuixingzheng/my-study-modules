package com.gof.code.observer;

/**
 * @author: cxz
 * @create: 2020/8/12 17:46
 * @description:
 **/
public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.attach(new HexObserver());
        subject.attach(new OctalObserver());
        subject.attach(new BinaryObserver());
        subject.setState(11);
        System.out.println();
        subject.setState(15);
    }
}
