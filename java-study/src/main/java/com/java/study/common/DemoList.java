package com.java.study.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: cxz
 * @create: 2021/8/27 17:45
 * @description:
 **/
public class DemoList {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            array.add(10);
        }
        array.set(0,1);
        array.set(1,2);
        array.set(2,3);
        array.set(3,4);
        array.set(4,5);
        array.remove(0);
        System.out.println(array.get(0));
    }
}
