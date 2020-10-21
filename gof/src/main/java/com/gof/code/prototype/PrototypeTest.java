package com.gof.code.prototype;

/**
 * @author: cxz
 * @create: 2020/8/5 17:31
 * @description:
 **/
public class PrototypeTest {
    public static void main(String[] args) {
        Square square = new Square();
        square.setId(1);
        square.setName("正方形");

        System.out.println("hashcode = " + square.hashCode());
        System.out.println(square);
        System.out.println("===================");
        Square clone = (Square) square.clone();
        System.out.println("hashcode = " + clone.hashCode());
        System.out.println(clone);

        clone.setName("正方形002");
        System.out.println(square);
        System.out.println(clone);
    }
}
