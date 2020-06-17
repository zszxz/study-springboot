package com.zszxz.controller;

import com.zszxz.service.ADD;
import com.zszxz.vo.SysUser;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Author lsc
 * <p> </p>
 */
@RestController
@Validated
public class SysUserController {

    // 方法参数为实体校验
    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody SysUser sysUser){

        return ResponseEntity.ok(sysUser);
    }

    // 方法参数校验
    @GetMapping("user")
    public ResponseEntity getUser(@NotNull(message ="用户名不能为空") String username) {
        SysUser sysUser = new SysUser();
        sysUser.setName("知识追寻者");
        return ResponseEntity.ok(sysUser);
    }

    // 分组校验
    @PostMapping("/user")
    public ResponseEntity addUser(@Validated(value = ADD.class) @RequestBody SysUser sysUser){

        return ResponseEntity.ok(sysUser);
    }
}
