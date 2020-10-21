package com.gof.code.visit;

/**
 * @author: cxz
 * @create: 2020/8/13 15:02
 * @description:
 **/
public class Computer implements Part {

    private Part[] parts;
    @Override
    public void describe() {
        System.out.println("computer contain : {");
        for (Part part : parts){
          part.describe();
        }
        System.out.println("}");
    }

    public Computer(Part[] parts) {
        this.parts = parts;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
