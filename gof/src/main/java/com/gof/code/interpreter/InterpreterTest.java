package com.gof.code.interpreter;

/**
 * @author: cxz
 * @create: 2020/8/13 17:52
 * @description:
 **/
public class InterpreterTest {

    public static void main(String[] args) {
        Context context = new Context();
        context.handleInfo("韶关的老人");
        context.handleInfo("广州的孕妇");
        context.handleInfo("中山的残疾");
        context.handleInfo("济南的残疾");
    }
}
