package com.gof.code.chainofresponsibility;

/**
 * @author: cxz
 * @create: 2020/8/11 17:48
 * @description:
 **/
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        super(level);
    }

    @Override
    void write(String message) {
        System.out.println("error message : " + message);
    }
}
