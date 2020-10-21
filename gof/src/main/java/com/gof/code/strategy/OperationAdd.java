package com.gof.code.strategy;

/**
 * @author: cxz
 * @create: 2020/8/13 13:40
 * @description:
 **/
public class OperationAdd implements Operation {
    @Override
    public int handler(int a, int b) {
        return a+b;
    }
}
