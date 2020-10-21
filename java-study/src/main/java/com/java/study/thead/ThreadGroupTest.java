package com.java.study.thead;

import java.util.concurrent.Executors;

/**
 * @author: cxz
 * @create: 2020/9/3 14:20
 * @description:
 **/
public class ThreadGroupTest {

    public static void main(String[] args) {
        ThreadGroup threadGroup1 = new ThreadGroup("线程组1");
        ThreadGroup threadGroup2 = new ThreadGroup("线程组2");



        new Thread(threadGroup1, () -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getThreadGroup().getName());
        }
        ).start();
        new Thread(threadGroup1, () -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getThreadGroup().getName());
        }
        ).start();

        System.out.println(threadGroup1.activeCount());
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadGroup1.activeCount());


        //Executors.newFixedThreadPool()
        threadGroup1.setDaemon(true);
        threadGroup1.activeCount();

    }
}
