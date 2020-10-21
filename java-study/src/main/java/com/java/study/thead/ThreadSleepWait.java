package com.java.study.thead;

/**
 * @author: cxz
 * @create: 2020/8/18 11:29
 * @description:
 **/
public class ThreadSleepWait {

    public static void main(String[] args) {
        ThreadSleepWait threadSleepWait = new ThreadSleepWait();
//        for (int i=0;i<5;i++){
//            new Thread(threadSleepWait::synSleep).start();
//        }
        for (int i=0;i<5;i++){
            new Thread(threadSleepWait::synWait).start();
        }
    }

    public synchronized  void synSleep(){
        String name = Thread.currentThread().getName();
        System.out.println("begin sleep thread name is " + name);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end sleep thread name is " + name);
    }

    public synchronized  void synWait(){
        String name = Thread.currentThread().getName();
        System.out.println("begin wait thread name is " + name);
        try {
            this.wait(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end wait thread name is " + name);
    }

}
