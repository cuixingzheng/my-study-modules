package com.java.study.thead;

/**
 * @author: cxz
 * @create: 2020/8/19 13:54
 * @description:
 **/
public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThInterruptRunnable());
        thread.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
    public static class ThInterruptRunnable implements Runnable{
        @Override
        public void run() {
            int i =0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(++i);
            }
        }
    }
}
