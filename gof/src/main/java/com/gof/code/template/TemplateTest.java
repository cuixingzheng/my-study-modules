package com.gof.code.template;

/**
 * @author: cxz
 * @create: 2020/8/13 14:11
 * @description:
 **/
public class TemplateTest {

    public static void main(String[] args) {
        Game cricket = new Cricket();
        cricket.play();
        System.out.println("-------------");
        Game football = new Football();
        football.play();
    }
}
