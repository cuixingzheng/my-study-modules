package com.gof.code.facade;

/**
 * @author: cxz
 * @create: 2020/8/11 14:12
 * @description:
 **/
public class ShapeMark {
    private Circle circle;
    private Rectangle rectangle;
    public ShapeMark() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
    }
    public void circleDraw(){
        circle.draw();
    }
    public void rectangleDraw(){
        rectangle.draw();
    }
}
