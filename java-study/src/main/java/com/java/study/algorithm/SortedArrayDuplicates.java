package com.java.study.algorithm;

/**
 * @author: cxz
 * @create: 2021/5/7 14:12
 * @description: 数组去重，要求空间复杂度为O（1）
 **/
public class SortedArrayDuplicates {

    public static void main(String[] args) {
        int[] ints = {0, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(ints));
    }

    public static int removeDuplicates(int[] array){
        //i和j为两个指针，i为慢指针，j为快指针，相等时j指针向前移动，不相等时i和j同时向前移动，并且将j的值赋值给i+1
        int i =0;
        for (int j = 1; j < array.length ; j++) {
            if(array[i] != array[j]){//如果两个指针的值不相等时，
                array[i+1] = array[j];//需要将j的值赋值给i+1
                i++;//i向前移动
            }
        }
        return i+1;
    }
}
