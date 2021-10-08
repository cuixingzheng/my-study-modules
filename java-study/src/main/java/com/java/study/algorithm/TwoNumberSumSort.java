package com.java.study.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cxz
 * @create: 2021/5/8 10:15
 * @description: 从有序数组中找出两个数之和等于target,找到后返回下标值数组
 **/
public class TwoNumberSumSort {


    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6};
        System.out.println(JSON.toJSONString(twoSearch(ints, 10)));
        System.out.println(JSON.toJSONString(twoPoint(ints, 10)));
    }

    //二分查找 时间复杂度o(n平方)*o(logn) 空间复杂度o(1)
    public static int[] twoSearch(int[] array,int target){

        for (int i = 0; i < array.length; i++) {
            int low = i; int hign = array.length -1;
            while (low <= hign){
                int mid = (hign - low)/2 + low;
                if(array[i] + array[mid] == target){
                    return new int[]{i,mid};
                }else if(array[i] + array[mid] > target){
                    hign = mid -1;
                }else {
                    low = mid +1;
                }
            }
        }
        return new int[]{-1};
    }

    //双指针 时间复杂度o(n),空间复杂度o(n),以空间换时间
    public static int[] twoPoint(int[] array,int target){
        int low = 0; int high = array.length -1;
        for (int i = 0; i < array.length; i++) {
            int sum = array[low] + array[high];
            if(sum == target){
                return new int[]{low,high};
            }else if(sum > target){
                high--;
            }else {
                low++;
            }
        }
        return new int[]{-1};
    }


}
