package com.zszxz.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @Author lsc
 * <p> </p>
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisStringTest {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    // string 入库
    @Test
    public void testForValue1(){
        String key = "zszxz";
        String value = "知识追寻者";
        redisTemplate.opsForValue().set(key, value);
    }
    
    // string 出库
    @Test
    public void testForValue2(){
        String key = "zszxz";
        Object value = redisTemplate.opsForValue().get(key);
        // 知识追寻者
        System.out.println(value);
    }

    // string key过期时间入库
    @Test
    public void testForValue3(){
        String key = "today";
        String value = "周六";
        long time = 60;
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }
}
