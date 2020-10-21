package com.gof.code.abstractfactory;

/**
 * @author: cxz
 * @create: 2020/8/5 11:10
 * @description:
 **/
public class AbstractFactoryTest {

    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.createFactory("形状工厂");
        Shape square = shapeFactory.createShape("正方形");
        square.show();
        System.out.println("----------");
        Shape triangle = shapeFactory.createShape("三角形");
        triangle.show();
        System.out.println("==========");
        AbstractFactory colorFactory = FactoryProducer.createFactory("颜色工厂");

        Color red = colorFactory.createColor("红色");
        red.draw();
        System.out.println("---------");
        Color green = colorFactory.createColor("绿色");
        green.draw();
    }
}
