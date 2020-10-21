package com.java.study.thead;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: cxz
 * @create: 2020/8/19 14:38
 * @description:
 **/
public class ThreadLock002 {

    private final static Lock lock = new ReentrantLock();

    private static int num = 0;

    public static void main(String[] args) {
        ThreadLockRunnable threadLockRunnable = new ThreadLockRunnable();
        Runnable runnable = threadLockRunnable::exeAdd;
        for (int i=0;i<10;i++){
            new Thread(runnable).start();
        }
    }


    public static class ThreadLockRunnable{
        private final Lock lock = new ReentrantLock();
        private int i=0;
        public void exeAdd(){
            lock.lock();
            try {
                for(int j=0;j<10;j++){
                    System.out.print(i++ + " ");
                }
                System.out.println();
            } finally {
                lock.unlock();
            }
        }
    }
}
