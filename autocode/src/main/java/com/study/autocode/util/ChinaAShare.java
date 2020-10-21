package com.study.autocode.util;

import java.math.BigDecimal;

/**
 * @author: cxz
 * @create: 2020/8/4 18:15
 * @description:
 **/
public class ChinaAShare {

    private static BigDecimal beginAmount = new BigDecimal("1");

    private static BigDecimal ratio = new BigDecimal("0.05");


    public static void main(String[] args) {
        System.out.println(calBigDecimal(18));
    }

    public static BigDecimal calBigDecimal(int num){
        if(num >=0){
            for (int i=0;i<num;i++){
               beginAmount  = beginAmount.add(beginAmount.multiply(ratio));
            }
        }
        return beginAmount;
    }
}
