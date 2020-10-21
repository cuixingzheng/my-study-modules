package com.gof.code.chainofresponsibility;

/**
 * @author: cxz
 * @create: 2020/8/11 17:51
 * @description:
 **/
public class InfoLogger extends AbstractLogger {
    public InfoLogger(int level) {
        super(level);
    }

    @Override
    void write(String message) {
        System.out.println("info message : " + message);
    }
}
