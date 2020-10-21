package com.java.study.thead;

/**
 * @author: cxz
 * @create: 2020/8/14 18:29
 * @description:
 **/
public class ThreadSynch {
    public static void main(String[] args) {
        //MyDemo myDemo = new MyDemo();
        for (int i=0;i<10;i++){
            new Thread(new MyDemo()).start();
        }
    }
    public static class MyDemo implements Runnable {
        private static int num = 0;
        @Override
        public void run() {
            addNumStatic();
        }
//        public static synchronized void addNumStatic(){
//            for (int i = 0; i < 10; i++) {
//                if (num % 10 == 0)
//                    System.out.println();
//                System.out.print(++num + " ");
//            }
//        }
        public void addNumStatic(){
            synchronized (this){
                for (int i = 0; i < 10; i++) {
                    if (num % 10 == 0)
                        System.out.println();
                    System.out.print(++num + " ");
                }
            }
        }
    }
}
