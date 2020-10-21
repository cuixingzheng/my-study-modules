package com.gof.code.visit;

/**
 * @author: cxz
 * @create: 2020/8/13 14:59
 * @description:
 **/
public abstract class Visitor {

    abstract void visit(Keyboard keyboard);
    abstract void visit(Mouse mouse);
    abstract void visit(Monitor monitor);
    abstract void visit(Computer computer);
}
