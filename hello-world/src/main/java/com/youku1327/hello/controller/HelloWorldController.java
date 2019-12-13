package com.youku1327.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author lsc
 * @Description hello world 控制层
 * @Date 2019/9/21 23:44
 * @Version 1.0
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/hello/springboot")
    @ResponseBody
    public String quick(){
        return "公众号 知识追寻者 hello world springboot!";
    }
}
