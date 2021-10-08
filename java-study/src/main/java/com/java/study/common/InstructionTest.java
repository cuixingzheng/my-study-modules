package com.java.study.common;

import java.util.ArrayList;

/**
 * @author: cxz
 * @create: 2020/9/18 17:39
 * @description:
 **/
public class InstructionTest {

    public static void main(String[] args) {
//        int a = 0;
//        for(int i = 0; i < 99; i++){
//            a = a++;
//        }
//        System.out.println(a);

        ArrayList<Integer> list = new ArrayList<>();

        set(list,2,2);
        set(list,5,5);
        set(list,10,10);
        //list.set(2,3);
        System.out.println(list);
    }

    public static void set(ArrayList list,int i,int val){
        if(list.size()<i){
            int length = list.size();
            for (int j = 0; j <= i - length ; j++) {
                list.add(null);
            }
        }
        list.set(i,val);
    }
}
