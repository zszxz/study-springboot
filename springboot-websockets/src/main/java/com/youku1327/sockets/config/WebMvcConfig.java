package com.youku1327.sockets.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author lsc
 * @Description <p> spingmvc视图映射转发</p>
 * @Date 2019/11/12 23:35
 */
@Configurable
@Component
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 配置视图转发
        registry.addViewController("/ws").setViewName("/WebSockets");
    }
}
