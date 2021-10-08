package com.java.study.algorithm;

/**
 * @author: cxz
 * @create: 2021/5/7 11:12
 * @description: 素数（质数）统计
 **/
public class PrimeStatistics {


    public static void main(String[] args) {
        //System.out.println(bf(100));
        System.out.println(bf001(100));
    }

    //暴力算法
    public static int bf(int num){
        int count = 0;
        for(int i = 2;i<num;i++){
            count += isPrime(i)?1:0;
        }
        return count;
    }
    //判断是否为素数
    public static boolean isPrime(int x){
        for (int i = 2; i*i <=x ; i++) {
            if(x%i == 0){
                //如果出现整除的时候 不是素数
                return false;
            }
        }
        return true;
    }



    //埃筛法
    public static int bf001(int num){
        //声明一个num长度的boolean数组，用于标记大于等于0小于等num素数标记（默认都是false，即false为素数）
        boolean[] primes = new boolean[num];
        int count = 0;
        for (int i = 2; i < primes.length; i++) {//从2开始遍历即可
            if(!primes[i]){
                count ++;
                //for (int j = 2*i; j < num; j+=i) {//或
                for (int j = i*i; j < num; j+=i) {//优化后
                    //对当前的合数进行演变到其他合数
                    primes[j] = true;
                }
            }
        }
        return count;
    }
}
