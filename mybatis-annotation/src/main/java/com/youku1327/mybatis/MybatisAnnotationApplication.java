package com.youku1327.mybatis;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author lsc
 * @Description springboot启动类
 * @Date 2019/9/21 0:49
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.youku1327.mybatis.mapper")
public class MybatisAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisAnnotationApplication.class,args);
    }

}
