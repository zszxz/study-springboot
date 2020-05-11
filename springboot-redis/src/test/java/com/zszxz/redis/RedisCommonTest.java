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
public class RedisCommonTest {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    // 测试 key 是否存在
    @Test
    public void test1(){
        String key = "zszxz";
        Boolean exist = redisTemplate.hasKey(key);
        // true
        System.out.println(exist);
    }
    // 设置 key 过期时间
    @Test
    public void test2(){
        String key = "zszxz";
        long time = 60;
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    // 获取key过期时间
    @Test
    public void test3(){
        String key = "zszxz";
        Long expire = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        // 7
        System.out.println(expire);
    }

    // 删除key
    @Test
    public void test4(){
        String key = "zszxz";
        redisTemplate.delete(key);
    }
}
