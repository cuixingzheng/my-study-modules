/**
 * 项目名：duia-statistic <br>
 * 包名：com.duia.statistic.common.data <br>
 * 文件名：GlobalRedisDataConfiguration.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2017年5月4日-下午12:02:57<br>
 * Copyright (c) 2017 赵增斌-版权所有<br>
 */
package com.distributed.lock.demo.config;

import com.distributed.lock.demo.util.ObjectUtils;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.temporal.ChronoUnit;


@Configuration
@EnableCaching
public class GlobalRedisDataConfiguration extends CachingConfigurerSupport {

    /**
     * 日志
     */
    private static final Logger LOGGER = Logger.getLogger(GlobalRedisDataConfiguration.class);

    @Autowired
    private ConfigRedis configRedis;

    @Bean
    public KeyGenerator wiselyKeyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };

    }


    private JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        if (ObjectUtils.isNotEmpty(configRedis.getMaxIdle())) {
            jedisPoolConfig.setMaxIdle(configRedis.getMaxIdle());
        }
        if (ObjectUtils.isNotEmpty(configRedis.getMaxWait())) {
            jedisPoolConfig.setMaxWaitMillis(configRedis.getMaxWait());
        }
        if (ObjectUtils.isNotEmpty(configRedis.getTestOnBorrow())) {
            jedisPoolConfig.setTestOnBorrow(configRedis.getTestOnBorrow());
        }
        return jedisPoolConfig;
    }


    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(configRedis.getIp());
        redisStandaloneConfiguration.setPort(configRedis.getPort());
        redisStandaloneConfiguration.setDatabase(configRedis.getDbName());
        redisStandaloneConfiguration.setPassword(RedisPassword.of(configRedis.getPassword()));

        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfigurationBuilder = JedisClientConfiguration.builder();
        JedisClientConfiguration jedisClientConfiguration = jedisClientConfigurationBuilder
                .connectTimeout(Duration.of(configRedis.getTimeout(), ChronoUnit.MILLIS))
                .usePooling()
                .poolConfig(jedisPoolConfig())
                .build();
        JedisConnectionFactory cf = new JedisConnectionFactory(redisStandaloneConfiguration,jedisClientConfiguration);
        cf.afterPropertiesSet();
        return cf;
    }


    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate() {
        return getRedisTemplate(false);
    }


    @Bean(name = "redisTemplateTransactional")
    public RedisTemplate<String, Object> redisTemplateTransactional() {
        return getRedisTemplate(true);
    }


    private RedisTemplate<String, Object> getRedisTemplate(Boolean isTransactional) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
                Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        template.setConnectionFactory(redisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        template.setEnableTransactionSupport(isTransactional);
        return template;
    }
}
