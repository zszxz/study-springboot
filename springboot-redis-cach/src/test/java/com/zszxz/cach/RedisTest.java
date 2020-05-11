package com.zszxz.cach;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author lsc
 * <p> </p>
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void RedisTests(){

        try {
            redisTemplate.opsForValue().set("name", "知识追寻者");
            Object object = redisTemplate.opsForValue().get("name");
            // 知识追寻者
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        redisTemplate.delete("UserEntity");
    }
}
