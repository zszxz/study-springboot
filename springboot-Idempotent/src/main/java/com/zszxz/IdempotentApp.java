package com.zszxz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author lsc
 * <p> </p>
 */
@SpringBootApplication
public class IdempotentApp {

    public static void main(String[] args) {

        SpringApplication.run(IdempotentApp.class,args);
    }
}
