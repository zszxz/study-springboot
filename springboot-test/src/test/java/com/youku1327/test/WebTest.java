package com.youku1327.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author lsc
 * @Description <p> web 测试 </p>
 * @Date 2019/10/20 18:33
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void exampleTest() throws Exception {
        // get请求  rui /youku1327 状态 200 期望值 Hello World youku1327
        ResultActions resultActions = this.mvc.perform(get("/youku1327")).andExpect(status().isOk())
                .andExpect(content().string("Hello World youku1327"));

    }

}
