package com.zszxz.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 扫描mapper文件
@MapperScan("com.zszxz.plus.mapper")
public class SpringbootMybatisPlusApplication {
    /* *
     * @Author lsc
     * <p>
     https://mp.baomidou.com/guide/annotation.html
     * </p>
     * @Param
     * @Return
     */

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisPlusApplication.class, args);
    }

}
