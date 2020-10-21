package com.java.study.thead;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: cxz
 * @create: 2020/8/19 15:13
 * @description:
 **/
public class ThreadReadWriteLock {
    private static int num = 0;
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock readWriteLock002 = new ReentrantReadWriteLock();
    public static void main(String[] args) {
        Runnable runnable = ThreadReadWriteLock::testWrite;
        for (int i=0;i<5;i++){
            new Thread(runnable).start();
        }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Runnable read = ThreadReadWriteLock::testRead;
        for (int i=0;i<5;i++){
            new Thread(read).start();
        }
    }
    public static void testWrite(){
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        writeLock.lock();
        try {
            for (int i=0;i<5;i++){
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() +" 在写：" + ++num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            writeLock.unlock();
        }
    }
    public static void testRead(){
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        readLock.lock();
        try {
            for(int i=0;i<5;i++){
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 在读 ： " + num);
            }
        } finally {
            readLock.unlock();
        }
    }
}
