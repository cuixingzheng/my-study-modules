package com.gof.code.strategy;

/**
 * @author: cxz
 * @create: 2020/8/13 13:45
 * @description:
 **/
public class Strategy {

    private Operation operation;

    public Strategy(Operation operation) {
        this.operation = operation;
    }

    int executeStrategy(int a,int b){
        return operation.handler(a,b);
    }
}
