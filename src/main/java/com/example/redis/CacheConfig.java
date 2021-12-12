/*
package com.example.redis;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

@Configuration

public class CacheConfig {
    


    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private RedisConnectionFactory factory;

    @Bean
    @Primary
    RedisCacheManager redisCacheManager() {
    
        final RedisCacheWriter writer = RedisCacheWriter.nonLockingRedisCacheWriter(factory);
        final GenericJackson2JsonRedisSerializer jackson = new GenericJackson2JsonRedisSerializer();
        final RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair
                .fromSerializer(jackson);
        final RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(pair).entryTtl(Duration.ofSeconds(30));
        final Map<String, RedisCacheConfiguration> conf = getConf();
        System.out.println(conf);
        return new RedisCacheManager(writer, config, conf);
    }


    @Bean
    public ConcurrentMapCacheManager cacheManager() {
    
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        return cacheManager;
    }


    private Map<String, RedisCacheConfiguration> getConf() {
    

        final Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Component.class);
        final List<CacheMap> collect = beansWithAnnotation.entrySet().stream().flatMap(entry -> {
    
            try {
    
                final Object value = entry.getValue();
                // 获得原本的class名字，spring代理的都是后面有$$直接截取即可
                String className = "";
                if (value.getClass().getName().contains("$")){
    
                    className = value.getClass().getName().
                            substring(0, value.getClass().getName().indexOf("$"));
                }else{
    
                    className = value.getClass().getName();
                }

                // 获得原始的字节码文件，如果被spring 代理之后，方法上会获取不到注解信息
                final Method[] methods = Class.forName(className)
                        .getDeclaredMethods();

                return Arrays.stream(methods).flatMap(method -> {
    
                    final Cacheable annotation = method.getAnnotation(Cacheable.class);
                    if (annotation == null) {
    
                        return null;
                    }
                    return Arrays.stream(annotation.cacheNames()).map(data -> {
    
                        if (data.contains("#")) {
    
                            // 包含自定义日期
                            final String[] split = data.split("#");
                            if (split.length != 2) {
    
                                return null;
                            }
                            final CacheMap cacheMap = new CacheMap();
                            cacheMap.setName(data);
                            final String s = split[1];
                            final int time = Integer.parseInt(s.substring(0, s.length() - 1));
                            if (s.endsWith("s")) {
    
                                cacheMap.setTtl(Duration.ofSeconds(time));
                            } else if (s.endsWith("m")) {
    
                                cacheMap.setTtl(Duration.ofMinutes(time));
                            } else if (s.endsWith("d")) {
    
                                cacheMap.setTtl(Duration.ofDays(time));
                            }
                            return cacheMap;
                        }
                        return null;
                    }).filter(Objects::nonNull);
                });


            } catch (Exception e) {
    
                System.out.println("异常");
                return null;
            }
        }).collect(Collectors.toList());

        return collect.stream().collect(Collectors.toMap(CacheMap::getName, p -> {
    
            final GenericJackson2JsonRedisSerializer jackson = new GenericJackson2JsonRedisSerializer();
            final RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair
                    .fromSerializer(jackson);
            return RedisCacheConfiguration.defaultCacheConfig()
                    .serializeValuesWith(pair).entryTtl(p.getTtl());
        }, (key1, key2) -> key2));
    }


    class CacheMap {
    
        private String name;
        private Duration ttl;

        public String getName() {
    
            return name;
        }

        public void setName(String name) {
    
            this.name = name;
        }

        public Duration getTtl() {
    
            return ttl;
        }

        public void setTtl(Duration ttl) {
    
            this.ttl = ttl;
        }
    }


}
*/
