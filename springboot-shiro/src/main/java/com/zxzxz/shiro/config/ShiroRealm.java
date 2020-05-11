package com.zxzxz.shiro.config;

import com.zxzxz.shiro.entity.PowerEntity;
import com.zxzxz.shiro.entity.RoleEntity;
import com.zxzxz.shiro.entity.UserEntity;
import com.zxzxz.shiro.service.PowerService;
import com.zxzxz.shiro.service.RoleService;
import com.zxzxz.shiro.service.UserService;
import com.zxzxz.shiro.utils.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author lsc
 * @Description <p> 认证和授权 </p>
 * @Date 2019/11/16 14:13
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {



        @Autowired
        private UserService userService;
        @Autowired
        private RoleService roleService;
        @Autowired
        private PowerService powerService;
        /*
         * @Author lsc
         * @Description <p>授权 1主角调用subject.hasRole("user") 或 subject.isPermitted("user");
         * 2使用注解 @RequiresRoles("user") 3 页面标签 4 认证url要求权限 里面的sql最好别出错要不然会报授权错误而不是sql语法异常</p>
         * @Date  2019/11/16 15:03
         * @Param [principalCollection]
         * @Return org.apache.shiro.authz.AuthorizationInfo
         */
        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            // 获取用户信息
            UserEntity userEntity = (UserEntity) principalCollection.getPrimaryPrincipal();
            //获取用户ID
            String userId =userEntity.getUserId();
            //存放角色
            Set<String> rolesSet = new HashSet<>();
            // 存放权限
            Set<String> permsSet = new HashSet<>();
            //根据用户id查询角色列表
            List<RoleEntity> roleEntityList = roleService.getRoleByuserId(userId);
            // 遍历角色列表
            for (RoleEntity roleEntity:roleEntityList) {
                rolesSet.add(roleEntity.getRoleName());
                // 通过角色id获得权限
                List<PowerEntity> powerEntityList = powerService.getPowerByRoleId(roleEntity.getRoleId());
                // 遍历权限
                for (PowerEntity powerEntity :powerEntityList) {
                    // 授权权限集合
                    permsSet.add(powerEntity.getPower());
                }
            }
            // 权限授权
            authorizationInfo.setStringPermissions(permsSet);
            // 角色授权
            authorizationInfo.setRoles(rolesSet);
            return authorizationInfo;
        }

        /*
         * @Author lsc
         * @Description <p>登陆的时候会进行身份认证 </p>
         * @Date  2019/11/16 14:53
         * @Param [authenticationToken]
         * @Return org.apache.shiro.authc.AuthenticationInfo
         */
        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)  {
            //获取用户的输入的账号.
            String userName = (String) authenticationToken.getPrincipal();
            // 通过用户名获得用户实体
            UserEntity user = userService.getUserByuserName(userName);
            //判断账号是否存在
            if (user == null) {
                log.error("账号或者密码错误");
                throw new AuthenticationException();
            }
            //判断账号是否被冻结
            if (user.getState().equals("prohibit")){
                log.error("账号被冻结:[{}]",userName);
                throw new LockedAccountException();
            }
            //进行验证
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    user,                                  //用户名
                    user.getPassword(),                    //密码
                    ByteSource.Util.bytes(user.getSalt()), //设置盐值
                    getName()
            );
            //清除缓存和Session
            ShiroUtils.deleteCache(userName,true);
            return authenticationInfo;
        }



}
