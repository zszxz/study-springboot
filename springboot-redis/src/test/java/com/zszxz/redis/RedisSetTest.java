package com.zszxz.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * @Author lsc
 * <p> </p>
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisSetTest {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    // set 中存储值
    @Test
    public void test1(){
        String key = "zszxz";
        String value1 = "晴雨天";
        String value2 = "公众号：知识追寻者";
        redisTemplate.opsForSet().add(key, value1, value2);
    }

    // 从 set 中取值
    @Test
    public void test2(){
        String key = "zszxz";
        Set<Object> members = redisTemplate.opsForSet().members(key);
        // [晴雨天, 公众号：知识追寻者]
        System.out.println(members);
    }

    // 判定 set 中是否存在 key-value
    @Test
    public void test3(){
        String key = "zszxz";
        String value = "晴雨天";
        Boolean member = redisTemplate.opsForSet().isMember(key, value);
        // true
        System.out.println(member);
    }
}
