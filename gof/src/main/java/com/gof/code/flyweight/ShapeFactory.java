package com.gof.code.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.random;

/**
 * @author: cxz
 * @create: 2020/8/11 15:03
 * @description:
 **/
public class ShapeFactory {
    private static Map<String,Shape> map = new HashMap<>();

    public static Shape getShapeByColor(String color){
        Circle shape = (Circle)map.get(color);
        if(shape == null){
            synchronized (ShapeFactory.class){
                if(shape == null){
                    Circle circle = new Circle();
                    circle.setColor(color);
                    circle.setX((int) (random()*10));
                    circle.setY((int)(random()*10));
                    map.put(color,circle);
                    System.out.println("create " + color + " circle");
                    return circle;
                }
                return shape;
            }
        }
        return shape;
    }





}


