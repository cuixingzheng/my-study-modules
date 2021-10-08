package com.java.study.jvm;

/**
 * @author: cxz
 * @create: 2021/6/3 18:17
 * @description:
 **/
public class JVMDeadLock {

    public static String obj1 = "obj1";
    public static String obj2 = "obj2";

    public static void main(String[] args) {
        Thread thread001 = new Thread(new Lock1());
        Thread thread002 = new Thread(new Lock2());
        Thread thread003 = new Thread(new Demo());
        Thread thread004 = new Thread(new Demo1());
        thread001.start();
        thread002.start();
//        thread003.start();
//        thread004.start();
    }

    static class Lock1 implements Runnable{
        @Override
        public void run(){
            try{
                System.out.println("Lock1 running");
                while(true){
                    synchronized(JVMDeadLock.obj1){
                        System.out.println("Lock1 lock obj1");
                        Thread.sleep(3000);//获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
                        synchronized(JVMDeadLock.obj2){
                            System.out.println("Lock1 lock obj2");
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    static class Lock2 implements Runnable{
        @Override
        public void run(){
            try{
                System.out.println("Lock2 running");
                while(true){
                    synchronized(JVMDeadLock.obj2){
                        System.out.println("Lock2 lock obj2");
                        Thread.sleep(3000);
                        synchronized(JVMDeadLock.obj1){
                            System.out.println("Lock2 lock obj1");
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    static class Demo implements Runnable{
        @Override
        public void run(){
            try{
                while(true){
                   Thread.sleep(100L);
                    System.out.println(".....");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    static class Demo1 implements Runnable{
        int i=0;
        @Override
        public void run(){
            try{
                while(true){
                    i++;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


}
