package com.gof.code.strategy;

/**
 * @author: cxz
 * @create: 2020/8/13 13:44
 * @description:
 **/
public class OperationMultiply implements Operation {
    @Override
    public int handler(int a, int b) {
        return a*b;
    }
}
