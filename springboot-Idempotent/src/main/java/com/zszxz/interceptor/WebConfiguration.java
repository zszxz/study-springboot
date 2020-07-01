package com.zszxz.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author lsc
 * <p> </p>
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    IdempotentInterceptor idempotentInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求
        registry.addInterceptor(idempotentInterceptor).addPathPatterns("/**");
    }

}
