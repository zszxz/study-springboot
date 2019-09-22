package com.youku1327.spring.session.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author lsc
 * @Description //spring session
 * @Date 2019/9/22 14:01
 * @Version 1.0
 */
@RestController
public class SpringSessionController {

    @GetMapping("set/spring/session")
    public String setSpringSession(HttpSession httpSession){
        httpSession.setAttribute("user","youku1327");
        System.out.println("设置session");
        return "set spring session success";
    }
    @GetMapping("get/spring/session")
    public String getSpringSession(HttpSession httpSession){
        httpSession.setAttribute("user","youku1327");
        System.out.println("响应session");
        return httpSession.getAttribute("user").toString();
    }
}
