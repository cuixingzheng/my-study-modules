package com.java.study.algorithm;

/**
 * @author: cxz
 * @create: 2021/5/11 18:25
 * @description: 最长连续递增序列 ：给定一个未经排序的整数数组，找到最长且连续递增的子序列，并返回该序列长度
 **/
public class MaxSeq {

    public static void main(String[] args) {
        int[] array = {1,2,3,2,3,4,5,3,4,5,6,7};
        System.out.println(findMaxLength(array));
    }

    //贪心算法 时间复杂度o（n） 空间复杂度o(1)
    public static int findMaxLength(int[] array){
        int max = 0; //最大连续数
        int start = 1;//最新连续递增
        for (int i = 1; i < array.length ; i++) {
            if(array[i] <= array[i-1]){
                start = i;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
