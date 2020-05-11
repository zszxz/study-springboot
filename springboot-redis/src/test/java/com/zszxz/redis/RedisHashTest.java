package com.zszxz.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lsc
 * <p> </p>
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisHashTest {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    // 放入一个 hash ( key value )
    @Test
    public void test1(){
        String key = "zszxz";
        String item = "name";
        String value = "知识追寻者";
        redisTemplate.opsForHash().put(key, item, value);
    }

    // 向hash中存放一个map
    @Test
    public void test2(){
        String key = "feature";
        Map<String, Object> map = new HashMap<>();
        map.put("name", "知识追寻者");
        map.put("age", "18");
        redisTemplate.opsForHash().putAll(key, map);
    }

    // 获取一个hash 的 所有key-value
    @Test
    public void test3(){
        String key = "feature";
        Map<Object, Object> entries = redisTemplate.opsForHash().entries(key);
        // {name=知识追寻者, age=18}
        System.out.println(entries);
    }

    // 获取一个hash 的 指定key 的value
    @Test
    public void test4(){
        String key = "feature";
        String item = "name";
        Object value = redisTemplate.opsForHash().get(key, item);
        // 知识追寻者
        System.out.println(value);
    }

    // 删除指定 hash key 的value
    @Test
    public void test5(){
        String key = "zszxz";
        String item = "name";
        redisTemplate.opsForHash().delete(key, item);
    }

    // 是否存在 指定 hash 的key
    @Test
    public void test6(){
        String key = "zszxz";
        String item = "name";
        Boolean exist = redisTemplate.opsForHash().hasKey(key, item);
        // false
        System.out.println(exist);
    }


}
