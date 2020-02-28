package com.zszxz.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lsc
 * <p> </p>
 */
@RestController
public class TestController {

    @GetMapping(value = "/api/test")
    public String get(){

        return "zszxz";
    }
}
