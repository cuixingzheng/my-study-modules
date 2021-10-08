package com.java.study.thead;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: cxz
 * @create: 2020/11/6 16:47
 * @description: Condition是在java 1.5中才出现的，它用来替代传统的Object的wait()、notify()实现线程间的协作，相比使用Object的wait()、notify()，使用Condition的await()、signal()这种方式实现线程间协作更加安全和高效。因此通常来说比较推荐使用Condition，阻塞队列实际上是使用了Condition来模拟线程间协作。
 **/
public class ThreadPoolConditionTest {

    //private static Semaphore semaphore = new Semaphore(2);
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public  static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(ThreadPoolConditionTest::printData);
        Thread.sleep(1000L);
        printData002();
        executorService.shutdown();
    }


    public static void printData(){
        try {
            lock.lock();
            System.out.println("thread name " + Thread.currentThread().getName() + " begin");
            System.out.println("thread name " + Thread.currentThread().getName() + " wait");
            condition.await();
            System.out.println("thread name " + Thread.currentThread().getName() + " get signal");
            System.out.println("thread name " + Thread.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void printData002(){
        try {
            lock.lock();
            System.out.println("thread name " + Thread.currentThread().getName() + " send signal");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
