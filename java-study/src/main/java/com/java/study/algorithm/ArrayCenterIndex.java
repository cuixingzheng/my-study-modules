package com.java.study.algorithm;

import java.util.Arrays;

/**
 * @author: cxz
 * @create: 2021/5/7 14:42
 * @description:
 **/
public class ArrayCenterIndex {

    public static void main(String[] args) {
        int[] ints = {1, 7, 3, 6, 5, 6};
        System.out.println(findCenterIndex(ints));
    }

    public static int findCenterIndex(int[] array){
        int sum = Arrays.stream(array).sum();
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];//累加
            if(total == sum){//累加后判断是否相等，相等即为最左侧中心下标
                return i;
            }
            sum -= array[i];//没有找到时需要减
        }
        return -1;
    }
}
