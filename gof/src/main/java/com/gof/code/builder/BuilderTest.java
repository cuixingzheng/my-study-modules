package com.gof.code.builder;

/**
 * @author: cxz
 * @create: 2020/8/5 16:43
 * @description:
 **/
public class BuilderTest {

    public static void main(String[] args) {
        Meal vegMeal = Builder.vegMeal();
        float allPrice = vegMeal.allPrice();
        System.out.println("allPrice = " + allPrice);
        vegMeal.showItem();
        System.out.println("=============");
        Meal nonVegMeal = Builder.nonVegMeal();
        float allPrice001 = nonVegMeal.allPrice();
        System.out.println("allPrice001 = " + allPrice001);
        nonVegMeal.showItem();
    }
}
