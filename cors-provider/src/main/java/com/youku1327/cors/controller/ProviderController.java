package com.youku1327.cors.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lsc
 * @Description <p> cors </p>
 * @Date 2019/10/20 21:32
 * @Version 1.0
 */
@RestController
public class ProviderController {

    @GetMapping("youku1327")
    public String getUser(){
        System.out.println("---------");
        return "hello youku1327";
    }
}
