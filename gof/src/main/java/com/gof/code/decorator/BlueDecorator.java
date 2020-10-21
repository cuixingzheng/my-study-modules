package com.gof.code.decorator;

/**
 * @author: cxz
 * @create: 2020/8/11 11:59
 * @description:
 **/
public class BlueDecorator extends DecoratorShape {
    public BlueDecorator(Shape shape) {
        super(shape);
    }
    @Override
    public void draw() {
        super.draw();
        System.out.println("the color is blue");
    }
}
