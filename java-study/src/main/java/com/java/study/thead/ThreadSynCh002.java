package com.java.study.thead;

/**
 * @author: cxz
 * @create: 2020/8/17 13:58
 * @description:
 **/
public class ThreadSynCh002 {
    public static void main(String[] args) {
        //ThreadSynch.MyDemo myDemo = new ThreadSynch.MyDemo();
        for (int i=0;i<100;i++){
            new Thread(new MyDemo()).start();
        }
    }
    public static class MyDemo implements Runnable {
        private static int num = 0;
        private static String lock = "duixiangsuo";


        @Override
        public void run() {
            addNumStatic();
        }
        public static void addNumStatic(){
            synchronized(lock){
                for (int i = 0; i < 10; i++) {
                    if (num % 10 == 0)
                        System.out.println();
                    System.out.print(++num + " ");
                }
            }
        }
    }
}
