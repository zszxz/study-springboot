package com.zxzxz.shiro.config;

import com.zxzxz.shiro.constant.RedisConstant;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @Author lsc
 * @Description <p>shiro 配置</p>
 * @Date  2019/11/16 15:09
 * @Param
 * @Return
 */
@Configuration
public class ShiroConfig {

    private final String CACHE_KEY = "zxzxz:cache:";
    private final String SESSION_KEY = "zxzxz:session:";
    private final int EXPIRE = 1800;

    //Redis配置
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Value("${spring.redis.password}")
    private String password;





   /*
    * @Author lsc
    * @Description <p>Shiro登陆拦截配置</p>
    * @Date  2019/11/16 15:10
    * @Param [securityManager]
    * @Return org.apache.shiro.spring.web.ShiroFilterFactoryBean
    */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactory(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 匿名用户可访问
        filterChainDefinitionMap.put("/user/login/**", "anon");
        filterChainDefinitionMap.put("/user/register/**", "anon");
        // 认证用户可访问
        filterChainDefinitionMap.put("/**", "authc");
        // 登陆url
        shiroFilterFactoryBean.setLoginUrl("/user/unauth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /*
     * @Author lsc
     * @Description <p> 安全管理器</p>
     * @Date  2019/11/16 15:30
     * @Param []
     * @Return org.apache.shiro.mgt.SecurityManager
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 自定义Ssession管理
        securityManager.setSessionManager(sessionManager());
        // 自定义Cache实现
        securityManager.setCacheManager(cacheManager());
        // 自定义Realm验证
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }


    /*
     * @Author lsc
     * @Description <p>身份验证域 </p>
     * @Date  2019/11/16 15:30
     * @Param []
     * @Return ShiroRealm
     */
    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(matcher());
        return shiroRealm;
    }

    /*
     * @Author lsc
     * @Description <p> 设置加密也可自行设置加密方式 </p>
     * @Date  2019/11/16 15:13
     * @Param []
     * @Return org.apache.shiro.authc.credential.HashedCredentialsMatcher
     */
    @Bean
    public HashedCredentialsMatcher matcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5"); //设置加密算法
        matcher.setHashIterations(1024);//设置加密算法的次数
        return matcher;
    }

    /*
     * @Author lsc
     * @Description <p>配置Redis管理器  </p>
     * @Date  2019/11/16 15:15
     * @Param []
     * @Return org.crazycake.shiro.RedisManager
     */
    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setTimeout(timeout);
        redisManager.setPassword(password);
        return redisManager;
    }

    /*
     * @Author lsc
     * @Description <p>配置Cache管理器 </p>
     * @Date  2019/11/16 15:29
     * @Param []
     * @Return org.crazycake.shiro.RedisCacheManager
     */
    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        redisCacheManager.setKeyPrefix(CACHE_KEY);
        redisCacheManager.setPrincipalIdFieldName("userId");
        return redisCacheManager;
    }

    /*
     * @Author lsc
     * @Description <p>SessionID生成器 </p>
     * @Date  2019/11/16 15:48
     * @Param []
     * @Return ShiroSessionIdGenerator
     */
    @Bean
    public ShiroSessionIdGenerator sessionIdGenerator(){
        return new ShiroSessionIdGenerator();
    }

    /*
     * @Author lsc
     * @Description <p> 配置RedisSessionDAO </p>
     * @Date  2019/11/16 15:29
     * @Param []
     * @Return org.crazycake.shiro.RedisSessionDAO
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        redisSessionDAO.setSessionIdGenerator(sessionIdGenerator());
        redisSessionDAO.setKeyPrefix(SESSION_KEY);
        redisSessionDAO.setExpire(EXPIRE);
        return redisSessionDAO;
    }

   /*
    * @Author lsc
    * @Description <p> 配置Session管理器</p>*
    * @Date  2019/11/16 15:19
    * @Param []
    * @Return org.apache.shiro.session.mgt.SessionManager
    */
    @Bean
    public SessionManager sessionManager() {
        ShiroSessionManager shiroSessionManager = new ShiroSessionManager();
        shiroSessionManager.setSessionDAO(redisSessionDAO());
        return shiroSessionManager;
    }


    /*
     * @Author lsc
     * @Description <p> 开启Shiro-aop注解支持</p>
     * @Date  2019/11/16 15:27
     * @Param [securityManager]
     * @Return org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /*
     * @Author lsc
     * @Description <p>自定义SessionId生成器 </p>
     * @Date  2019/11/16 15:22
     * @Param
     * @Return
     */
    public class ShiroSessionIdGenerator implements SessionIdGenerator {

        @Override
        public Serializable generateId(Session session) {
            // 生成uuid当作sessionId
            Serializable sessionId = new JavaUuidSessionIdGenerator().generateId(session);
            // token前缀+uuuid
            return String.format(RedisConstant.PREFIX_LOGIN, sessionId);
        }
    }
}