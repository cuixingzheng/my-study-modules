package com.java.study.algorithm;

/**
 * @author: cxz
 * @create: 2021/5/11 16:25
 * @description: 子数组中最大平均数，给定一个整数数组，找出平均数最大且长度为k的下标连续的子数组，并输出该最大平均数
 **/
public class AvgArray {

    public static void main(String[] args) {
        int[] array = {1,12,-5,-6,50,3};
        System.out.println(findMaxAvg(array, 4));
    }

    //滑动窗口 时间复杂度o(n),空间复杂度o(1)
    public static double findMaxAvg(int[] array,int k){
        int i;
        int sum = 0;
        //将第一个滑动窗口求和
        for (i = 0; i < k; i++) {
            sum += array[i];
        }

        int max = sum;
        for (i = k;i<array.length;i++){//向后滑动
            sum = sum - array[i-k] + array[i];//减掉前一个，加上后一个
            if(sum > max)
                max = sum;
        }
        return 1.0*max/k;
    }
}
