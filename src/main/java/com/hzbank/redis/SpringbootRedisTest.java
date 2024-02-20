package com.hzbank.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2024/1/25 14:14
 * @Description: test
 * @Version 1.0.0
 */

@SpringBootTest
public class SpringbootRedisTest {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    void contextLoads() {
        stringRedisTemplate.opsForValue().set("k1","springBoot整合测试");
        String k1 = stringRedisTemplate.opsForValue().get("k1");
        System.out.println("k1 = " + k1);
    }
}
