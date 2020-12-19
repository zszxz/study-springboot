package com.zszxz;

import com.zszxz.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

/**
 * @Author lsc
 * <p> </p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest {


    @Autowired
    Task task;

    @Test
    public void test() throws Exception {
        Future<String> str1 = task.taskOne();
        Future<String> str2 = task.taskTwo();
        while (true){
            // 如果任务都做完就执行如下逻辑
            if (str1.isDone() && str2.isDone()){
                System.out.println(str1.get()+":"+str2.get());
                break;
            }
        }
    }

    @Test
    public void testPool() throws Exception {
        task.sayHello("公众号：知识追寻者");
    }


}
