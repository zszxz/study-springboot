package com.youku1327.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/10/20 17:36
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
// 如果没有main主类，是顶级类要指定classes
@SpringBootTest(classes = TestConfig.class)
public class Youku1Test {

    @Test
    public void test(){
        TestConfig testConfig = new TestConfig();
        String user = testConfig.getUser();
        // youku1327
        System.out.println(user);
    }
}
