package com.gof.code.flyweight;

/**
 * @author: cxz
 * @create: 2020/8/11 15:00
 * @description:
 **/
public class Circle implements Shape{
    private String color;
    private int x;
    private int y;
    @Override
    public void draw() {
        String msg = "Circle{" +
                "color='" + color + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
        System.out.println(msg);
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
