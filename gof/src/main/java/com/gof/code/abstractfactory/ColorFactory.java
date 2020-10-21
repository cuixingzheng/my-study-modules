package com.gof.code.abstractfactory;

/**
 * @author: cxz
 * @create: 2020/8/5 11:04
 * @description:
 **/
public class ColorFactory implements AbstractFactory {
    @Override
    public Shape createShape(String shapeName) {
        return null;
    }

    @Override
    public Color createColor(String colorName) {
        if("红色".contains(colorName)){
            return new Red();
        }else if("绿色".contains(colorName)){
            return new Green();
        }
        return null;
    }
}
