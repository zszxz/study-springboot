package com.zszxz.controller;

import com.zszxz.annotation.MonitorLog;
import com.zszxz.eu.LogEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lsc
 * <p> </p>
 */
@RestController
public class UserController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @MonitorLog(value="查询用户",operateType = LogEnum.SELECT)
    @GetMapping("zszxz")
    public String getUser(String user){
        return "zszxz";
    }


}
