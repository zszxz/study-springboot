package com.zxzxz.shiro.controller;

import com.zxzxz.shiro.entity.UserEntity;
import com.zxzxz.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lsc
 * @Description <p>权限控制层测试 </p>
 * @Date 2019/11/19 11:19
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    UserService userService;


    @GetMapping("/test")
    public ResponseEntity<Map> anno(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("test","登陆用户可以访问");
        return ResponseEntity.ok(map);
    }
    /*
     * @Author lsc
     * @Description <p> 需要 user:info权限才可以访问</p>
     * @Date  2019/11/19 17:45
     * @Param []
     * @Return org.springframework.http.ResponseEntity<java.util.Map>
     */
    @GetMapping("/perm")
    @RequiresPermissions("user:info")
    public ResponseEntity<Map> has(){
        HashMap<Object, Object> map = new HashMap<>();
        PrincipalCollection manager = SecurityUtils.getSubject().getPrincipals();
        map.put("principal",manager);
        return ResponseEntity.ok(map);
    }
    /*
     * @Author lsc
     * @Description <p>需要 manager 角色才可以访问 </p>
     * @Date  2019/11/19 17:45
     * @Param []
     * @Return org.springframework.http.ResponseEntity<java.util.List>
     */
    @GetMapping("/user")
    @RequiresRoles(value = {"manager"})
    public ResponseEntity<List> getUser(){
        List<UserEntity> userList = userService.getUserList();
        return ResponseEntity.ok(userList);
    }
    /*
     * @Author lsc
     * @Description <p> 需要manager user 权限才可以访问，如果逻辑关系设置为or，其中的一个角色都可以访问</p>
     * @Date  2019/11/19 17:44
     * @Param []
     * @Return org.springframework.http.ResponseEntity<java.util.List>
     */
    @GetMapping("/whl")
    @RequiresRoles(value = {"manager","user"},logical = Logical.AND)
    public ResponseEntity<List> moreRole(){
        List<UserEntity> userList = userService.getUserList();
        return ResponseEntity.ok(userList);
    }
}
