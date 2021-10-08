package com.java.study.common;

/**
 * @author: cxz
 * @create: 2021/9/3 18:01
 * @description:
 **/
public class IntegerTest {

    public static void main(String[] args) {

        System.out.println(new Integer(1) == new Integer(1));
        System.out.println(new Integer(1) == 1);

        Integer a = 1;
        Integer b = 1;
        System.out.println(a == b);

        System.out.println(new Long(1) == new Long(1));
        Long c = 1L;
        Long d = 1L;
        System.out.println(c == d);

        Integer e = 300;
        Integer f = 300;
        System.out.println(e == f);
    }
}
