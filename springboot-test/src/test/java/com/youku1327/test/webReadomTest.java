package com.youku1327.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/10/20 19:27
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class webReadomTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void exampleTest() {
        EntityExchangeResult<String> entityExchangeResult = this.webClient.get()
                .uri("/youku1327").exchange().expectStatus().isOk()
                .expectBody(String.class).returnResult();
        // Hello World youku1327
        System.out.println(entityExchangeResult.getResponseBody());
    }

}
