package com.gof.code.abstractfactory;

/**
 * @author: cxz
 * @create: 2020/8/5 10:56
 * @description:
 **/
public class ShapeFactory implements AbstractFactory {
    @Override
    public Shape createShape(String shapeName) {
        if("正方形".contains(shapeName)){
            return new Square();
        }else if("三角形".contains(shapeName)){
            return new Triangle();
        }
        return null;
    }

    @Override
    public Color createColor(String colorName) {
        return null;
    }
}
