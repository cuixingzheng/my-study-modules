package com.java.study.thead;

/**
 * @author: cxz
 * @create: 2020/8/14 17:02
 * @description:
 **/
public class MultiThread {


    public static void main(String[] args) {

        MyDemo myDemo = new MyDemo();

        new Thread(myDemo).start();
        new Thread(myDemo).start();
        new Thread(myDemo).start();
        new Thread(myDemo).start();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myDemo.interrupt();
    }


    public static class MyDemo implements Runnable{

        String st = "ss";
        private int num = 0;

        public  void addNum(){
            for(int i=0;i<10;i++){
                if(num%10==0)
                    System.out.println();
                System.out.print( ++num + " ");
            }
        }

        public  void play(){
            synchronized (st){
                try {
                    System.out.println("开始 wait");
                    st.wait();
                    System.out.println("结束 wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        public  void interrupt(){
            synchronized(st){
                st.notifyAll();
            }
        }

        @Override
        public void run() {
            //addNum();
            play();
        }
    }




}
