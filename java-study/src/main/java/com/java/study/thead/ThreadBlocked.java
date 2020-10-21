package com.java.study.thead;

/**
 * @author: cxz
 * @create: 2020/8/17 14:52
 * @description:
 **/
public class ThreadBlocked {

    public static void main(String[] args) {
        ThreadBlocked threadBlocked = new ThreadBlocked();
        ThreadBlocked threadBlocked001 = new ThreadBlocked();
        ThreadBlocked threadBlocked002 = new ThreadBlocked();
        new Thread(threadBlocked::blocked).start();
        new Thread(threadBlocked001::blocked).start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(threadBlocked002::notifyBlocked).start();//要保证是一个对象
    }
    private  void blocked(){
        synchronized(ThreadBlocked.class){//锁对象和lock.wait()必须相同
            try {
                System.out.println("开始 wait");
                ThreadBlocked.class.wait();
                System.out.println("执行 wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private  void notifyBlocked(){
        synchronized(ThreadBlocked.class){//锁对象与lock.notifyAll();必须相同
            try {
                Thread.sleep(5000L);
                ThreadBlocked.class.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sleepBlocked(){
        try {
            System.out.println("开始 sleep");
            Thread.sleep(20000L);
            System.out.println("结束 sleep");
        } catch (InterruptedException e) {
            System.out.println("线程被唤醒");
            e.printStackTrace();
        }
    }



}
