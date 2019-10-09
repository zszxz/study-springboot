package com.youku1327.excetion.controller;

import com.youku1327.excetion.response.CodeMsg;
import com.youku1327.excetion.response.CommonException;
import com.youku1327.excetion.response.ResultPage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author lsc
 * @Description <p> 控制层</p>
 * @Date 2019/10/9 20:57
 * @Version 1.0
 */
@RestController
public class YouKu1327Controller {


    @GetMapping("/youku1327/api/excetion")
    public ResultPage<Object> testException(){
        // 示范 抛出自定义异常
        throw new CommonException(CodeMsg.Request_Error);
    }
    /*
     * @Author lsc
     * @Description  <p>成功消息 </p>
     * @Date 2019/10/9 21:21
     * @Param []
     * @return org.springframework.http.ResponseEntity
     **/
    @GetMapping("/youku1327/api/sucess")
    public ResponseEntity testSucess(){
        ArrayList<Object> list = new ArrayList<>();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("youku1327","欢迎关注博客和微信号");
        list.add(hashMap);
        return ResponseEntity.ok().body(ResultPage.sucess(CodeMsg.SUCESS,list));
    }
}
