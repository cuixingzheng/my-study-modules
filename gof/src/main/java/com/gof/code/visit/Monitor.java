package com.gof.code.visit;

/**
 * @author: cxz
 * @create: 2020/8/13 14:56
 * @description:
 **/
public class Monitor implements Part {
    @Override
    public void describe() {
        System.out.println("this is monitor");
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
