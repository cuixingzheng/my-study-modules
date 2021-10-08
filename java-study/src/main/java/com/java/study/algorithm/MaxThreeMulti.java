package com.java.study.algorithm;

import java.util.Arrays;

/**
 * @author: cxz
 * @create: 2021/5/7 18:49
 * @description: 求出数组中三个数相乘的最大数值
 **/
public class MaxThreeMulti {

    public static void main(String[] args) {
        int[] ints = {-3, -2, 0, 5, 7, 8, 4, 5, 9};
        System.out.println(sortMe(ints));
        System.out.println(lineScan(ints));
    }

    //排序方式 时间复杂度 nlogn
    public static int sortMe(int[] array){
        if(array.length<3){
            throw new IllegalArgumentException("array is error");
        }
        Arrays.sort(array);
        int n = array.length;
        return Math.max(array[0]*array[1]*array[n-1],array[n-3]*array[n-2]*array[n-1]);
    }

    //线性扫描 时间复杂度o(n)
    public static int lineScan(int[] array){
        if(array.length<3){
            throw new IllegalArgumentException("array is error");
        }
        int min1 = Integer.MAX_VALUE; int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE; int max2 = Integer.MIN_VALUE; int max3 = Integer.MIN_VALUE;
        for (int x : array){
            if(x < min1){//小于最小的
                min2 = min1;//将原来最小的赋值给第二小的
                min1 = x;//设置最小值
            }else if(x<min2){//小于第二小的
                min2 = x;
            }

            if(x > max1){
                max3 = max2;
                max2 = max1;
                max1 = x;
            }else if(x > max2){
                max3 = max2;
                max2 = x;
            }else if(x > max3){
                max3 = x;
            }
        }
        return Math.max(min1 * min2 * max1,max3 * max2 * max1);
    }




}
