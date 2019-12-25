package com.zszxz.actuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lsc
 * <p> </p>
 */
@RestController
public class ActutorController {


    @GetMapping("test")
    public String test(){
        return "知识追寻者";
    }
}
