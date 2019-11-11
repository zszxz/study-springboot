package com.youku1327.scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author lsc
 * @Description <p> 任务调度启动类 </p>
 * @Date 2019/11/11 22:20
 */
@SpringBootApplication
// 开启任务调度
@EnableScheduling
public class ScheduledApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledApplication.class,args);
    }
}
