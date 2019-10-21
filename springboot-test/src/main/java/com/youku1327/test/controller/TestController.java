package com.youku1327.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/10/20 18:53
 * @Version 1.0
 */
@RestController
public class TestController {

    @GetMapping("youku1327")
    public String getUser(){
        return "Hello World youku1327";
    }
}
