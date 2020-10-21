package com.gof.code.abstractfactory;

/**
 * @author: cxz
 * @create: 2020/8/5 10:54
 * @description:
 **/
public interface AbstractFactory {

     Shape createShape(String shapeName);

     Color createColor(String colorName);

}
