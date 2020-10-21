package com.gof.code.abstractfactory;

/**
 * @author: cxz
 * @create: 2020/8/5 11:07
 * @description:
 **/
public class FactoryProducer {

    public static AbstractFactory createFactory(String factoryName){
        if("形状工厂".contains(factoryName)){
            return new ShapeFactory();
        }else if("颜色工厂".contains(factoryName)){
            return new ColorFactory();
        }
        return null;
    }
}
