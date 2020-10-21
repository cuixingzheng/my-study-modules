package com.java.study.thead;

import java.security.PublicKey;
import java.util.concurrent.*;

/**
 * @author: cxz
 * @create: 2020/8/14 11:14
 * @description:
 **/
public class CallableTest {

    public static void main(String[] args) throws Exception {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    public static class MyCallable implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            return 1;
        }
    }
}
