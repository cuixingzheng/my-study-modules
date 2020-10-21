package com.gof.code.visit;

/**
 * @author: cxz
 * @create: 2020/8/13 15:09
 * @description:
 **/
public class VisitorPo extends Visitor{
    @Override
    void visit(Keyboard keyboard) {
        keyboard.describe();
    }
    @Override
    void visit(Mouse mouse) {
        mouse.describe();
    }
    @Override
    void visit(Monitor monitor) {
       monitor.describe();
    }
    @Override
    void visit(Computer computer) {
        computer.describe();
    }
}
