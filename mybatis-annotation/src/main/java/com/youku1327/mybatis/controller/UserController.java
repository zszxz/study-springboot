package com.youku1327.mybatis.controller;

import com.youku1327.mybatis.entity.UserEntity;
import com.youku1327.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
 * @Author lsc
 * @Description 控制层
 * @Date 2019/9/20 23:55
 * @Version 1.0
 */
@RestController // 相当于 @Controller 注解 + @responseBody
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "info")
    public ResponseEntity<Integer> addUser(@RequestBody UserEntity userEntity){
        int count = userService.addUser(userEntity);
        // 返回条数
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }

    @GetMapping("info")
    public ResponseEntity<UserEntity> getUsers(Long userId){
        UserEntity users = userService.getUsers(userId);
        return ResponseEntity.ok(users);
    }

    @PutMapping("info/{userId}")
    public ResponseEntity<Integer> updateUser(@RequestBody UserEntity userEntity,@PathVariable Long userId){
        int count = userService.updateUser(userEntity,userId);
        // 返回条数
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }

    @DeleteMapping("info/{userId}")
    public ResponseEntity<Integer> delUser(@PathVariable Long userId){
        int count = userService.delUser(userId);
        return ResponseEntity.ok(count);
    }
}
