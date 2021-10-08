package com.java.study.algorithm;

/**
 * @author: cxz
 * @create: 2021/5/10 9:44
 * @description: 斐波那契数列  规则：一个数是前两个之和 如：0,1,1,2,3,5,8,13,21,34,55
 **/
public class Fib {

    public static void main(String[] args) {
        System.out.println(cal(10));
        System.out.println(cal2(10));
        System.out.println(twoPoint(10));
    }

    //暴力算法1(递归算法) 时间复杂度o(2的n次方) 空间复杂度o(1)
    public static int cal(int num){
        if(num == 0){
            return 0;
        }
        if(num == 1){
            return 1;
        }
        return cal(num - 1) + cal(num - 2);
    }

    //暴力算法2(递归算法) 时间复杂度o(n) 空间复杂度o(n)
    public static int cal2(int num){
        int[] array = new int[num + 1];
        return recursion(array,num);
    }

    public static int recursion(int[] array,int num){
        if(num == 0){
            return 0;
        }
        if(num == 1){
            return 1;
        }
        if(array[num] != 0){
            return array[num];
        }
        return array[num] = recursion(array, num - 1) + recursion(array, num - 2);
    }


    //双指针 时间复杂度o(n) 空间复杂度o(1)
    public static int twoPoint(int num){
        int low = 0;
        int high = 1;
        for (int i = 2; i <= num; i++) {
            int sum = low + high;
            low = high;
            high = sum;
        }
        return high;
    }

}
