package com.java.study.spring.ss;

/**
 * @author: cxz
 * @create: 2021/3/2 15:09
 * @description:
 **/
public class Test {

    public static void main(String[] args) {

        AbstractFood food = new KeLe();
        food.eat();
        System.out.println(food.getClass());

        if(food instanceof Water){
            ((Water)food).eat1();
        }


    }
}
