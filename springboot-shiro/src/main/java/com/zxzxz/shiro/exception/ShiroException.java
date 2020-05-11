package com.zxzxz.shiro.exception;

import com.zxzxz.shiro.response.CodeMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lsc
 * @Description <p> 自定义异常 </p>
 * @Date 2019/11/16 12:14
 */
@ControllerAdvice
@Slf4j
public class ShiroException {

    @ResponseBody
    // 认证异常
    @ExceptionHandler(value = AuthenticationException.class)
    public ResponseEntity authenticationException(){
        Map<Integer,Object> map = new HashMap<>();
        map.put(CodeMsg.AUTNORIZED_ERROR.getCode(),CodeMsg.AUTNORIZED_ERROR.getMsg());
        return ResponseEntity.ok(map);
    }

   /* @ResponseBody
    // 授权异常
    @ExceptionHandler(value = AuthorizationException.class)
    public ResponseEntity authorizationException(){
        Map<Integer,Object> map = new HashMap<>();
        log.error("no power");
        map.put(CodeMsg.PERMISSION_Error.getCode(),CodeMsg.PERMISSION_Error.getMsg());
        return ResponseEntity.ok(map);
    }*/

    @ResponseBody
    // 账号锁住异常
    @ExceptionHandler(value = LockedAccountException.class)
    public ResponseEntity lockedAccountException(){
        Map<Integer,Object> map = new HashMap<>();
        map.put(CodeMsg.ACCOUNT_ERROR.getCode(),CodeMsg.ACCOUNT_ERROR.getMsg());
        return ResponseEntity.ok(map);
    }

    @ResponseBody
    // 未知账号异常
    @ExceptionHandler(value = UnknownAccountException.class)
    public ResponseEntity unknownAccountException(){
        Map<Integer,Object> map = new HashMap<>();
        map.put(CodeMsg.Unknown_ACCOUNT.getCode(),CodeMsg.Unknown_ACCOUNT.getMsg());
        return ResponseEntity.ok(map);
    }
}
