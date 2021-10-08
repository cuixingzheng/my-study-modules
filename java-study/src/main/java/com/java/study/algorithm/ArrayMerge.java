package com.java.study.algorithm;

import java.util.Arrays;

/**
 * @author: cxz
 * @create: 2021/5/10 18:52
 * @description: 两个有序数组合并 例如数组1：[1,3,...,m,0,0,0,0],数组2：[2,4,6,8] 将数据2合并到数组1中，并返回数组1
 **/
public class ArrayMerge {

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,7,9,0,0,0,0};
        int[] nums2 = {2,4,6,8};
        //System.out.println(Arrays.toString(merge(nums1,5,nums2,4)));
        //System.out.println(Arrays.toString(merge002(nums1,5,nums2,4)));
        System.out.println(Arrays.toString(merge003(nums1,5,nums2,4)));
    }

    //使用java默认API 时间复杂度o((m+n)*logm+n) 空间复杂度o(1)
    public static int[] merge(int[] nums1,int m,int[] nums2,int n){
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
        return nums1;
    }

    //使用另外数组 时间复杂度o(m+n) 空间复杂度o(m+n)
    public static int[] merge002(int[] nums1,int m,int[] nums2,int n){
        int[] nums_copy = new int[m];
        System.arraycopy(nums1,0,nums_copy,0,m);
        int p1 = 0;//指针1
        int p2 = 0;//指针2
        int p =0;//总指针
        while (p1 < m && p2 < n){
            nums1[p++] = nums_copy[p1] < nums2[p2] ? nums_copy[p1++] : nums2[p2++];//移动较小的
        }
        if(p1 < m){
            System.arraycopy(nums_copy,p1,nums1,p1+p2,m+n-p1-p2);//没有移动完的 将剩余数据copy
        }
        if(p2 < n){
            System.arraycopy(nums2,p2,nums1,p1+p2,m+n-p1-p2);//没有移动完的 将剩余数据copy
        }
        return nums1;
    }


    //使用原数组 时间复杂度o(m+n) 空间复杂度o(1)
    public static int[] merge003(int[] nums1,int m,int[] nums2,int n){
        int p1 = m - 1;//num1中原始有效数据指针
        int p2 = n - 1;//num2中指针
        int p = m + n - 1;//num总指针

        while (p1 >= 0 && p2 >= 0){
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        if(p2 >= 0){//如果num2有剩余数据 则需要copy剩余数据   num1有剩余无需关心
            System.arraycopy(nums2,p2,nums1,0,p2 + 1);
        }

        return nums1;
    }



}
