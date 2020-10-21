package com.gof.code.chainofresponsibility;

/**
 * @author: cxz
 * @create: 2020/8/11 17:53
 * @description:
 **/
public class ChainofresponsibilityTest {

    private static AbstractLogger getAbstractLogger(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.error);
        AbstractLogger warnLogger = new WarnLogger(AbstractLogger.WARN);
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(warnLogger);
        warnLogger.setNextLogger(infoLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger abstractLogger = getAbstractLogger();
        abstractLogger.loadMessage(AbstractLogger.error,"error log");
        System.out.println("--------------");
        abstractLogger.loadMessage(AbstractLogger.WARN,"warn log");
        System.out.println("--------------");
        abstractLogger.loadMessage(AbstractLogger.INFO,"info log");
    }

}
