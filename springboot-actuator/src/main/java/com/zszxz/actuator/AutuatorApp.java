package com.zszxz.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author lsc
 * <p> </p>
 */
@SpringBootApplication
public class AutuatorApp {

    public static void main(String[] args) {
        SpringApplication.run(AutuatorApp.class, args);
    }

    /* *
     * @Author lsc
     * <p>
            https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/html/
            health  http://localhost:8080/actuator/health
     *      beans  http://localhost:8080/actuator/beans
     * </p>
     * @Param
     * @Return
     */
}
