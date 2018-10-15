package com.javartisan.spring.cache.javartisancache;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.util.Arrays;

import static java.util.Collections.singletonMap;
import static org.springframework.data.redis.cache.RedisCacheConfiguration.defaultCacheConfig;

@SpringBootApplication
@EnableCaching
public class JavartisanCacheApplication implements ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(JavartisanCacheApplication.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));

        System.out.println(applicationContext);
    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {

        RedisCacheManager cm = RedisCacheManager.builder(connectionFactory)
                // cache1与cache2为缓存名字

                // 设置缓存1的过期属性
                .withInitialCacheConfigurations(singletonMap("cache1", defaultCacheConfig().disableCachingNullValues().entryTtl(Duration.ofSeconds(15)).prefixKeysWith("spring-cache1:")))
                // 设置缓存2的过期属性
                .withInitialCacheConfigurations(singletonMap("cache2", defaultCacheConfig().disableCachingNullValues().entryTtl(Duration.ofSeconds(10)).prefixKeysWith("spring-cache2:")))
                .transactionAware()
                .build();
        return cm;
    }


}
