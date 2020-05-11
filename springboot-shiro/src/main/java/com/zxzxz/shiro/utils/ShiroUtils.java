package com.zxzxz.shiro.utils;

import com.zxzxz.shiro.entity.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.LogoutAware;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisSessionDAO;

import java.util.Collection;
import java.util.Objects;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/11/18 9:16
 */
public class ShiroUtils {

    private static RedisSessionDAO redisSessionDAO = SpringUtils.getBean(RedisSessionDAO.class);

    /*
     * @Author lsc
     * @Description <p>删除用户缓存信息 </p>
     * @Date  2019/11/16 15:07
     * @Param [userName, removeSession]
     * @Return void
     */
    public static void deleteCache(String userName, boolean removeSession){
        //从缓存中获取Session
        Session session = null;
        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
        UserEntity userEntity;
        Object attribute = null;
        for(Session sessionInfo : sessions){
            //遍历Session,找到该用户名称对应的Session
            attribute = sessionInfo.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (attribute == null) {
                continue;
            }
            // 获得用户信息
            userEntity = (UserEntity) ((SimplePrincipalCollection) attribute).getPrimaryPrincipal();
            if (userEntity == null) {
                continue;
            }
            // 判断用户名相同 赋值session信息
            if (Objects.equals(userEntity.getUserName(), userName)) {
                session=sessionInfo;
            }
        }
        // 如果session为空则返回
        if (session == null||attribute == null) {
            return;
        }
        //session不为空删除session
        if (removeSession) {
            redisSessionDAO.delete(session);
        }
        //删除Cache，在访问受限接口时会重新授权
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        Authenticator authc = securityManager.getAuthenticator();
        ((LogoutAware) authc).onLogout((SimplePrincipalCollection) attribute);
    }
}
