package com.youku1327.cors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/10/20 21:32
 * @Version 1.0
 */
@Controller
public class ComsumerController {

    @GetMapping("youku1327")
    public String getUser(){
        return "index";
    }
}
