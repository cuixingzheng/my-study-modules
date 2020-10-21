package com.java.study.thead;

/**
 * @author: cxz
 * @create: 2020/8/18 14:16
 * @description:
 **/
public class ThreadYield {
    public static void main(String[] args) {
        new Thread(() ->new ThreadYield().yieldMe()).start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() ->new ThreadYield().me()).start();
    }
    private void me(){
        long begin = System.currentTimeMillis();
        for (int i=0;i<1000000;i++){

        }
        System.out.println("common time is " + (System.currentTimeMillis() - begin));
    }
    private synchronized void yieldMe(){
        long begin = System.currentTimeMillis();
        for (int i=0;i<1000000;i++){
            Thread.yield();
        }
        System.out.println("yield time is " + (System.currentTimeMillis() - begin));
    }
}
