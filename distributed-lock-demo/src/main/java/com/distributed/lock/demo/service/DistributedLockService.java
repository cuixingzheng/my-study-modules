package com.distributed.lock.demo.service;

import com.distributed.lock.demo.config.RedissonManager;
/*import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;*/
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: cxz
 * @create: 2020/11/4 14:34
 * @description:
 **/
@Service
public class DistributedLockService {

    @Autowired
    private RedisTemplate redisTemplate;

    public static int count = 50;

    public static String lock = "lock";

    public void distributedLockMethod(){
//        System.out.println(redisTemplate.hashCode());
//        Boolean status = redisTemplate.opsForValue().setIfAbsent("key", "dd");
//        System.out.println(status);
        ExecutorService pool = Executors.newFixedThreadPool(1);
//        while (count >0){
//            //pool.submit(this::creatOrder);
//            //pool.submit(this::creatOrder002);
//            //pool.submit(this::creatOrder003);
//            //pool.submit(this::creatOrder004);
//            //pool.submit(this::creatOrder005);
//            pool.submit(this::creatOrder006);
//        }
        creatOrder006();

    }

    public void creatOrder() {
        if(count >0){
            System.out.println("正在秒杀商品，商品数量为 ： " + count);
            count--;
        }
    }

    public synchronized void creatOrder002() {
        if(count >0){
            System.out.println("正在秒杀商品，商品数量为 ： " + count);
            count--;
        }
    }

    public void creatOrder003() {
        Boolean status = redisTemplate.opsForValue().setIfAbsent(lock, lock);
        if(status){
            if(count >0){
                System.out.println("正在秒杀商品，商品数量为 ： " + count);
                count--;
            }
        }
        redisTemplate.delete(lock);
    }

    public void creatOrder004() {
        Boolean status = redisTemplate.opsForValue().setIfAbsent(lock, lock);
        try {
            if (status) {
                redisTemplate.expire(lock, 100, TimeUnit.SECONDS);
                if (count > 0) {
                    System.out.println("正在秒杀商品，商品数量为 ： " + count);
                    count--;
                }
            }
        } finally {
            redisTemplate.delete(lock);
        }
    }

    public void creatOrder005() {
        String value = UUID.randomUUID().toString();
        Boolean status = redisTemplate.opsForValue().setIfAbsent(lock, value);
        if(status){
            long beginTime = System.currentTimeMillis();
            redisTemplate.expire(lock,20, TimeUnit.SECONDS);
            try {
                if (count > 0) {
                    System.out.println("正在秒杀商品，商品数量为 ： " + count);
                    count--;
                }
            } finally {
                if (value.equals((String) redisTemplate.opsForValue().get(lock))) {
                    redisTemplate.delete(lock);
                }
                System.out.println("Time is : " + (System.currentTimeMillis() - beginTime));
            }
        }
    }

    public void creatOrder006() {
        Redisson redisson = RedissonManager.getRedisson();
        RLock lock = redisson.getLock("lock");
        lock.lock(10, TimeUnit.SECONDS);
        try {
            if (count > 0) {
                System.out.println("正在秒杀商品，商品数量为 ： " + count);
                count--;
            }
        } finally {
            lock.unlock();
        }
    }


}
