package com.java.study.thead;

/**
 * @author: cxz
 * @create: 2020/8/19 11:04
 * @description:
 **/
public class NoVisibility {

    private static class ReaderThread implements Runnable {
        private volatile int number = 0;
        @Override
        public void run() {
           for (int i=0;i<10;i++){
               if(number%10==0)
                   System.out.println();
               System.out.print(++number + " ");
           }
        }
    }
     public static void main(String[] args) {
         ReaderThread readerThread = new ReaderThread();
         for (int i=0;i<10;i++){
           new Thread(readerThread).start();
         }

       }



}
