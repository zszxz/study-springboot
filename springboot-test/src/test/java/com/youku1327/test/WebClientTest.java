package com.youku1327.test;

import com.youku1327.test.controller.TestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * @Author lsc
 * @Description <p> https://docs.spring.io/spring/docs/5.1.3.RELEASE/spring-framework-reference/testing.html#testing-resources</p>
 * @Date 2019/10/20 19:00
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
@WebFluxTest(TestController.class)
public class WebClientTest {

   WebTestClient webClient = WebTestClient.bindToController(new TestController()).build();

    /*@Autowired
    private WebTestClient webClient;*/

    @Test
    public void exampleTest() {

        EntityExchangeResult<String> entityExchangeResult = webClient.get().uri("/youku1327").exchange().expectStatus().isOk()
                .expectBody(String.class).returnResult();
        // Hello World youku1327
        System.out.println(entityExchangeResult.getResponseBody());
    }
}
