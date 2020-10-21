package com.gof.code.chainofresponsibility;

/**
 * @author: cxz
 * @create: 2020/8/11 17:42
 * @description:
 **/
public abstract class AbstractLogger {

    public static final int INFO = 1;
    public static final int WARN = 2;
    public static final int error = 3;
    protected int level;
    private AbstractLogger nextLogger;
    public AbstractLogger(int level) {
        this.level = level;
    }
    abstract void write(String message);
    void loadMessage(int level,String message){
        if(this.level <= level){
            write(message);
        }
        if(nextLogger != null){
            nextLogger.loadMessage(level,message);
        }
    }
    public AbstractLogger getNextLogger() {
        return nextLogger;
    }
    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }
}
