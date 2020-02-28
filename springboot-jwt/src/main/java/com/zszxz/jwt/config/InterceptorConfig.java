package com.zszxz.jwt.config;

import com.zszxz.jwt.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* *
 * @Author lsc
 * <p>拦截器配置 </p>
 * @Param
 * @Return
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /* *
     * @Author lsc
     * <p> 设置拦截路径 </p>
     * @Param [registry]
     * @Return void
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login");
    }
    /* *
     * @Author lsc
     * <p> 将拦截器注入context </p>
     * @Param []
     * @Return com.zszxz.jwt.interceptor.JwtInterceptor
     */
    @Bean
    public JwtInterceptor authenticationInterceptor() {
        return new JwtInterceptor();
    }

    /* *
     * @Author lsc
     * <p>跨域支持 </p>
     * @Param [registry]
     * @Return void
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS", "HEAD")
                .maxAge(3600 * 24);
    }
}
