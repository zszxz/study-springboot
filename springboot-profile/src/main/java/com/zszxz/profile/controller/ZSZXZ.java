package com.zszxz.profile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lsc
 * <p> </p>
 */
@RestController
public class ZSZXZ {

    @GetMapping("zszxz")
    public String hello(){
        return "hello 知识追寻者";
    }
}
