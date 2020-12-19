package com.zszxz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author lsc
 * <p> </p>
 */
@SpringBootApplication
@EnableAsync
public class AsyncRunApp {

    public static void main(String[] args) {
        SpringApplication.run(AsyncRunApp.class, args);
    }
}
