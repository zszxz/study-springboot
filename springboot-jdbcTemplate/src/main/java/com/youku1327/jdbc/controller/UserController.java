package com.youku1327.jdbc.controller;

import com.youku1327.jdbc.entity.User;
import com.youku1327.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author lsc
 * @Description <p>user 控制层 </p>
 * @Date 2019/11/2 10:43
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    // 查询user
    @GetMapping("user/{id}")
    public User getUser(@PathVariable Long id){
        return userService.findUserbyId(id);
    }
    // 添加user
    @PostMapping("user")
    public int addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    //修改 user
    @PutMapping("user/{id}")
    public int updateUser(@PathVariable Long id,@RequestBody User user){
        user.setId(id);
        return userService.updateUser(user);
    }

    // 删除user
    @DeleteMapping("user/{id}")
    public int deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
