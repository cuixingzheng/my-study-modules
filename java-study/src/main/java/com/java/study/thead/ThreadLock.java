package com.java.study.thead;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: cxz
 * @create: 2020/8/19 14:38
 * @description:
 **/
public class ThreadLock {
    private final static Lock lock = new ReentrantLock(true);
    private static int num = 0;
    public static void main(String[] args) {
        Runnable runnable = ThreadLock::test;
        for (int i=0;i<5;i++){
            new Thread(runnable).start();
        }
    }
    public static void test(){
        for (int i = 0; i < 2; i++) {
            lock.lock();
            try {
            System.out.println("线程" + Thread.currentThread().getName());
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
