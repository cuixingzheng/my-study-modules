package com.gof.code.facade;

/**
 * @author: cxz
 * @create: 2020/8/11 14:14
 * @description:
 **/
public class FacadeTest {

    public static void main(String[] args) {
        ShapeMark shapeMark = new ShapeMark();
        shapeMark.circleDraw();
        System.out.println("--------");
        shapeMark.rectangleDraw();
    }
}
