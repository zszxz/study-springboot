package com.youku1327.cors.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/10/20 23:15
 * @Version 1.0
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8082")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH")
                .allowedHeaders("*");
    }
}
