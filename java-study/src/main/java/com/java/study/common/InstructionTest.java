package com.java.study.common;

/**
 * @author: cxz
 * @create: 2020/9/18 17:39
 * @description:
 **/
public class InstructionTest {

    public static void main(String[] args) {
        int a = 0;
        for(int i = 0; i < 99; i++){
            a = a++;
        }
        System.out.println(a);
    }
}
