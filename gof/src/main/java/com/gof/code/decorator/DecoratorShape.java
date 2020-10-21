package com.gof.code.decorator;

/**
 * @author: cxz
 * @create: 2020/8/11 11:56
 * @description:
 **/
public abstract class DecoratorShape implements Shape {
    private Shape shape;
    public DecoratorShape(Shape shape) {
        this.shape = shape;
    }
    @Override
    public void draw() {
        shape.draw();
    }
}
