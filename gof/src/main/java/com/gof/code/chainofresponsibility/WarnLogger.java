package com.gof.code.chainofresponsibility;

/**
 * @author: cxz
 * @create: 2020/8/11 17:50
 * @description:
 **/
public class WarnLogger extends AbstractLogger {
    public WarnLogger(int level) {
        super(level);
    }
    @Override
    void write(String message) {
        System.out.println("warn message : " + message);
    }
}
