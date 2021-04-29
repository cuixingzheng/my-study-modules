package com.distributed.lock.demo.config;

//import org.redisson.Redisson;
//import org.redisson.config.Config;

import org.redisson.Redisson;
import org.redisson.config.Config;

/**
 * @author: cxz
 * @create: 2020/11/5 17:39
 * @description:
 **/
public class RedissonManager {

    private static Config config = new Config();
    //声明redisso对象
    private static Redisson redisson = null;
    //实例化redisson
    static{
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.229.100:6379").setConnectionPoolSize(50);
        redisson = (Redisson) Redisson.create(config);
    }

    //获取redisson对象的方法
    public static Redisson getRedisson(){
        return redisson;
    }
}
