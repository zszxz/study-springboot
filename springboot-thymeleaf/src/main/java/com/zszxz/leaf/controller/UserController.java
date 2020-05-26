package com.zszxz.leaf.controller;

import com.zszxz.leaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

/**
 * @Author lsc
 * <p> </p>
 */
@Controller//声明一个控制器
public class UserController {

    @GetMapping("/user")// 请求路径为 ip + port + /user
    // 当访问此路径时会转发至逻辑视图 user
    public String getUser(Model model){
        // list中存放 用户
        ArrayList<User> userList = new ArrayList<>();
        for (long i=0; i<5; i++){
            User user = new User();
            user.setId(i);
            user.setAge(18);
            user.setName("知识追寻者");
            userList.add(user);
        }
        // 为视图添加用户
        model.addAttribute("users",userList);
        // 逻辑视图为 user 即在 templates 下的 user.html
        return "user";
    }

}
