package com.gof.code.visit;

/**
 * @author: cxz
 * @create: 2020/8/13 14:58
 * @description:
 **/
public class Keyboard implements Part {
    @Override
    public void describe() {
        System.out.println("this is keyboard");
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
