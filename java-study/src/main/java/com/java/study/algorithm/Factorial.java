package com.java.study.algorithm;

import java.math.BigInteger;

/**
 * @author: cxz
 * @create: 2021/5/19 14:36
 * @description: 设计一个函数，求出n的阶乘后数据 零的个数
 **/
public class Factorial {

    public static void main(String[] args) {
        //1*2*3*4*5*6
        System.out.println(factorialFun(15));
//        System.out.println(factorialFun001(5));
//        System.out.println(factorialFun002(BigInteger.valueOf(5)));
        // System.out.println(BigInteger.valueOf(10).divide(BigInteger.valueOf(3)));
        System.out.println(zeroCount(15));
        System.out.println(trailingZeroes(15));
        System.out.println(trailingZeroes002(15));
        System.out.println(trailingZeroes003(15));
    }
    //阶乘1（long类型递归）
    public static long factorialFun(long n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return n*factorialFun(n-1);
    }
    //阶乘2（BigInteger迭代）
    public static String  factorialFun001(int num){
        BigInteger bigInteger = BigInteger.ONE;
        for (int i = 1; i <= num; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        return bigInteger.toString();
    }
    //阶乘3（BigInteger递归）
    public static BigInteger  factorialFun002(BigInteger num){
        if(num.compareTo(BigInteger.ONE) == 0){
            return BigInteger.ONE;
        }
        return num.multiply(factorialFun002(num.subtract(BigInteger.ONE)));
    }



    //计算阶乘后值中0出现的次数
    //取余方法 时间复杂度o(n平方)
    public static int zeroCount(int num){
        BigInteger nFactorial = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
        }
        // Count how many 0's are on the end.
        int zeroCount = 0;
        while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            nFactorial = nFactorial.divide(BigInteger.TEN);
            zeroCount++;
        }
        return zeroCount;
    }

    //只需算出5因子个数即可（原因：2的因子必定比5的因子要多） 时间复杂度o(n)
    public static int trailingZeroes(int n) {
        int zeroCount = 0;
        for (int i = 5; i <= n; i += 5) {
            int currentFactor = i;
            while (currentFactor % 5 == 0) {
                zeroCount++;
                currentFactor /= 5;
            }
        }
        return zeroCount;
    }

    //只需算出5因子个数即可,之后都是5倍因子（ 时间复杂度o(logn)
    public static int trailingZeroes002(int n) {
        int zeroCount = 0;
        // We need to use long because currentMultiple can potentially become
        // larger than an int.
        long currentMultiple = 5;
        while (n >= currentMultiple) {
            zeroCount += (n / currentMultiple);
            currentMultiple *= 5;
        }
        return zeroCount;
    }


    //只需算出5因子个数即可,之后都是5倍因子（ 时间复杂度o(logn) 与trailingZeroes002相同
    public static int trailingZeroes003(int n) {
        int zeroCount = 0;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }



}



