package com.zszxz.kafka;

import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lsc
 * <p> </p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void testSend(){
        for (int i = 0; i < 1000; i++) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("userId", i);
            map.put("getCount", i);
            //向kafka的 zszxz_topic 推送数据
            kafkaTemplate.send("zszxz_topic", JSONObject.toJSONString(map));
        }
    }

}
