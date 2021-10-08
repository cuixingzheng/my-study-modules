package com.java.study.thead;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: cxz
 * @create: 2021/7/2 17:12
 * @description:
 **/
public class ThreadLocalTest {
    //创建一个ThreadLocal变量，类型为Integer，初始值为null
//    private static ThreadLocal<Integer> localVar = new ThreadLocal<Integer>();
//
//    private static ThreadLocal<Integer> localVar001 = new ThreadLocal<Integer>(){
//        @Override
//        protected Integer initialValue() {
//            return 1;
//        }
//    };

    public static void main(String[] args) {
//        for (int i = 0; i < 10 ; i++) {
//            //new Thread(ThreadLocalTest::method0).start();
//            new Thread(ThreadLocalTest::method1).start();
//        }
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        for (int i = 0; i < 10; i++) {
//            executorService.submit(ThreadLocalTest::method1);
//        }
//        executorService.shutdown();
        method1();;

    }

//    private static void method0(){
//        while (true) {
//            Integer abc = localVar.get();
//            if (abc == null) {
//                //设置当前线程初始值
//                localVar.set(1);
//            } else {
//                //对当前线程值加1
//                localVar.set(++abc);
//                System.out.println("Thread Name is " + Thread.currentThread().getName() + ",value is " + localVar.get());
//                localVar.remove();
//                break;
//            }
//        }
//    }

    private static void method1(){
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        Integer abc = threadLocal.get();
        threadLocal.set(1);
        Integer abc002 = threadLocal.get();
        System.out.println("Thread Name is " + Thread.currentThread().getName() + ",value is " + abc002);
    }

    private static void memoryLeak(){
        //问题： new Integer(1)会不会出现内存泄露问题
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(new Integer(1));
        threadLocal.remove();
        Integer value = threadLocal.get();
        System.out.println("Thread Name is " + Thread.currentThread().getName() + ",value is " + value);
        threadLocal = null;
    }

}
