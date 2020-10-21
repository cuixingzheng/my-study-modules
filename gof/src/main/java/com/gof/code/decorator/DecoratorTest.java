package com.gof.code.decorator;

/**
 * @author: cxz
 * @create: 2020/8/11 13:52
 * @description:
 **/
public class DecoratorTest {
    public static void main(String[] args) {
        Shape redDecorator = new RedDecorator(new Circle());
        Shape blueDecorator = new BlueDecorator(new Circle());
        Shape redDecoratorRect = new RedDecorator(new Rectangle());
        Shape blueDecortorRect = new BlueDecorator(new Rectangle());
        redDecorator.draw();
        System.out.println("------------");
        blueDecorator.draw();
        System.out.println("------------");
        redDecoratorRect.draw();
        System.out.println("------------");
        blueDecortorRect.draw();
    }
}
