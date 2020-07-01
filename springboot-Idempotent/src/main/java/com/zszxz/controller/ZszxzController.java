package com.zszxz.controller;

import com.alibaba.fastjson.JSONObject;
import com.zszxz.annotation.Idempotent;
import com.zszxz.response.CodeMsg;
import com.zszxz.response.ResultPage;
import com.zszxz.utils.TokenUtis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lsc
 * <p> </p>
 */
@RestController
public class ZszxzController {

    @Autowired
    TokenUtis tokenUtis;

    @GetMapping("zszxz/token")
    public ResultPage getToken(){
        String token = tokenUtis.generateToken();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token",token);
        return ResultPage.sucess(CodeMsg.SUCESS,jsonObject);
    }

    @Idempotent
    @GetMapping("zszxz/test")
    public ResultPage testIdempotent(){
        return ResultPage.sucess(CodeMsg.SUCESS,"校验成功");
    }
}
