package com.gof.code.strategy;

/**
 * @author: cxz
 * @create: 2020/8/13 13:51
 * @description:
 **/
public class StrategyTest {

    public static void main(String[] args) {
        Strategy strategy = new Strategy(new OperationAdd());
        int result = strategy.executeStrategy(5, 4);
        System.out.println("5 + 4 = " + result);
        strategy = new Strategy(new OperationSubtract());
        result = strategy.executeStrategy(5,4);
        System.out.println("5 - 4 = " + result);
        strategy = new Strategy(new OperationMultiply());
        result = strategy.executeStrategy(5,4);
        System.out.println("5 * 4 = " + result);
    }
}
