package com.zszxz.shiro.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author lsc
 * <p> </p>
 */
@Configuration
public class ShiroConfiguration {

    // http://shiro.apache.org/spring.html

    // shiro授权拦截
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactory(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 创建一个map ， 配置拦截信息
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 匿名用户可访问
        filterChainDefinitionMap.put("login/**", "anon");
        filterChainDefinitionMap.put("register/**", "anon");
        // 认证用户可访问
        filterChainDefinitionMap.put("/**", "authc");
        // 登陆url
        shiroFilterFactoryBean.setLoginUrl("/user/unauth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    /* *
     * @Author lsc
     * <p>安全管理器，管理多个subject </p>
     * @Param []
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(Realm());
        return securityManager;
    }

    /* *
     * @Author lsc
     * <p>认证信息 </p>
     * @Param []
     */
    @Bean
    public ShiroRealm Realm() {
        // 我们实现的认证授权类
        ShiroRealm realm = new ShiroRealm();
        // 这边配置了加密设置，在用户登陆时创建密码的方式也要一致
        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        return realm;
    }
    /* *
     * @Author lsc
     * <p> 加密凭证</p>
     * @Param []
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 采用md5加密
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        // 循环加密2次
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }
    /* *
     * @Author lsc
     * <p> 开启Shiro-aop注解支持，比如使用到 @RequiresRoles, @RequiresPermissions ，
     * 其依赖于shiro生命周期</p>
     * @Param [securityManager]
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /* *
     * @Author lsc
     * <p> shiro生命周期</p>
     * @Param []
     */
    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanProcessor() {

        return new LifecycleBeanPostProcessor();
    }
}
