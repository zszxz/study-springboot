package com.zxzxz.shiro.controller;

import com.zxzxz.shiro.entity.UserEntity;
import com.zxzxz.shiro.response.CodeMsg;
import com.zxzxz.shiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lsc
 * @Description <p> 用户控制层</p>
 * @Date 2019/11/16 16:04
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class LoginController {

    @Autowired
    UserService userService;

    /*
     * @Author lsc
     * @Description <p>登陆认证 </p>
     * @Date  2019/11/18 10:45
     * @Param [userEntity]
     * @Return ResponseEntity<Map>
     */
    @GetMapping("/login")
    public ResponseEntity<Map> login(@RequestParam String userName,@RequestParam String password ){
        Map<String,Object> map = new HashMap<>();
        Subject subject = null;
        UsernamePasswordToken token = null;
        try {
            // 获得主角
            subject = SecurityUtils.getSubject();
            // 认证
            token = new UsernamePasswordToken(userName, password);
            //验证成功进行登录操作
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            log.error("密码错误:[{}]",e.getMessage());
            e.printStackTrace();
        }catch (UnknownAccountException e) {
            log.error("未知错误:[{}]",e.getMessage());
            e.printStackTrace();
        }catch(ExcessiveAttemptsException e) {
            log.error("登陆次数过多:[{}]",e.getMessage());
            e.printStackTrace();
        }
        map.put("token", SecurityUtils.getSubject().getSession().getId().toString());
        return ResponseEntity.ok(map);
    }
    /*
     * @Author lsc
     * @Description <p>未登陆,前端收到这条消息应跳转至登陆页面 </p>
     * @Date  2019/11/18 10:49
     * @Param []
     * @Return org.springframework.http.ResponseEntity<java.util.Map>
     */
    @GetMapping("/unauth")
    public ResponseEntity<Map> unauthorized(){
        Map<Integer,Object> map = new HashMap<>();
        map.put(CodeMsg.UNAUTHORIZED.getCode(),CodeMsg.UNAUTHORIZED.getMsg());
        return ResponseEntity.ok(map);
    }
    /*
     * @Author lsc
     * @Description <p>用户注册，去重自行操作 </p>
     * @Date  2019/11/18 16:10
     * @Param [userEntity]
     * @Return org.springframework.http.ResponseEntity
     */
    @PostMapping("/register")
    public ResponseEntity unauth(@RequestBody UserEntity userEntity){
        String hashAlgorithmName = "MD5";
        String credentials = userEntity.getPassword();
        int hashIterations = 1024;
        ByteSource credentialsSalt = ByteSource.Util.bytes(userEntity.getSalt());
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        userEntity.setPassword(simpleHash.toString());
        Integer count = userService.addUser(userEntity);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/logout")
    public  ResponseEntity  logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResponseEntity.ok("用户已注销");
    }

}
