package com.java.study.common;

/**
 * @author: cxz
 * @create: 2021/9/7 16:12
 * @description:
 **/
public class CircleTest {

    public static void main(String[] args) {
        int r = 0;
        int i;
        ok:
        for (i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                r++;
                if(r == 10){
                    break ok;
                }
            }

        }

        System.out.println(i);
    }
}
