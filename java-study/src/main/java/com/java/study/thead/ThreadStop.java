package com.java.study.thead;

/**
 * @author: cxz
 * @create: 2020/8/19 10:23
 * @description:
 **/
public class ThreadStop {
    public static void main(String[] args) {
        ThStopRunnable thStopRunnable = new ThStopRunnable();
        new Thread(thStopRunnable).start();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thStopRunnable.stopTh();
    }
    public static class ThStopRunnable implements Runnable{
        private volatile boolean exit = true;
        private void thRun(){
            int i =0;
            while (exit){
                System.out.println(++i);
            }
        }
        private   void stopTh(){
            exit = false;
        }
        @Override
        public void run() {
            thRun();
        }
    }
}
