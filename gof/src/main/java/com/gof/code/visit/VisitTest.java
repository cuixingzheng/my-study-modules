package com.gof.code.visit;

/**
 * @author: cxz
 * @create: 2020/8/13 15:07
 * @description:
 **/
public class VisitTest {

    public static void main(String[] args) {
        Part[] parts = {new Keyboard(),new Mouse(),new Monitor()};
        Computer computer = new Computer(parts);
        computer.accept(new VisitorPo());
        System.out.println();
        Keyboard keyboard = new Keyboard();
        keyboard.accept(new VisitorPo());
        System.out.println();
        Mouse mouse = new Mouse();
        mouse.accept(new VisitorPo());
        System.out.println();
        Monitor monitor = new Monitor();
        monitor.accept(new VisitorPo());
    }
}
