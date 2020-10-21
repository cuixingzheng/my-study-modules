package com.gof.code.flyweight;

/**
 * @author: cxz
 * @create: 2020/8/11 15:12
 * @description:
 **/
public class FlyweightTest {

    public static void main(String[] args) {
        String[] colors = {"red","blue","yellow","black","white","green"};
        for (int i=0;i<10;i++){
            int j = i % 5;
            Shape shape = ShapeFactory.getShapeByColor(colors[j]);
            shape.draw();
            System.out.println();
        }
    }
}
