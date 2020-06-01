package com.zszxz.shiro.controller;

import com.zszxz.shiro.entity.SysUserEntity;
import com.zszxz.shiro.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lsc
 * <p> </p>
 */
public class UserController {

    @Autowired
    SysUserService sysUserService;


    @PostMapping(value = "login")
    public ResponseEntity login(@RequestBody SysUserEntity sysUserEntity) {
        String username = sysUserEntity.getUsername();
        Subject subject = SecurityUtils.getSubject();
        // shiro认证
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, sysUserEntity.getPassword());
        // jwt 集成 shiro认证
        SysUserEntity user = sysUserService.getUserByUserName(username);
        Map map = new HashMap();
        if (user==null){
            System.out.println("用户名不能为空");
            // 抛异常
        }
        try {
            // shiro认证认证
            subject.login(usernamePasswordToken);
            map.put("name",user.getName());

        } catch (AuthenticationException e) {
            System.out.println("认证失败"+e.getMessage());
        }
        return ResponseEntity.ok(map);
    }

    @PostMapping("register")
    public ResponseEntity unauth(@RequestBody SysUserEntity sysUserEntity){
        SysUserEntity userByUserName = sysUserService.getUserByUserName(sysUserEntity.getUsername());
        if (userByUserName!=null){
            System.out.println("用户名不能为空");
            // 抛异常
        }
        // 加密方式
        String hashAlgorithmName = "MD5";
        String credentials = sysUserEntity.getPassword();

        // 加密次数
        int hashIterations = 2;
        // 生成盐,默认长度 16 位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
        // 加密后的密码
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        // 设置加密后的密码
        sysUserEntity.setPassword(simpleHash.toString());
        // 设置盐
        sysUserEntity.setSalt(salt);
        // r入库
        sysUserService.addSysUser(sysUserEntity);
        return ResponseEntity.ok(sysUserEntity);
    }
}
