package com.youku1327.restTemplate.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/10/14 11:51
 * @Version 1.0
 */
@RestController
@RequestMapping("/youku1327")
public class ProviderController {


    @GetMapping("user")
    public String getUser(){
        return "youku1327";
    }

    @GetMapping("user/{name}")
    public String getUserName(@PathVariable String name){
        return name;
    }

    @PostMapping("provider")
    public ResponseEntity<String> addData(@RequestBody JSONObject jsonObject){
        String user = (String) jsonObject.get("user");
        return ResponseEntity.ok(user);
    }

    @PutMapping("provider/{id}")
    public ResponseEntity<JSONObject> updateData(@PathVariable Long id, @RequestBody JSONObject jsonObject){
        Object object = jsonObject.get("user");
        jsonObject.put("id",id);
        // {"id":1327,"user":"youku1327"}
        System.out.println(jsonObject);
        return ResponseEntity.ok(jsonObject);
    }

    @DeleteMapping("provider/{id}")
    public ResponseEntity<String> delData(@PathVariable Long id){
        String result = "delete"+id+"success";
        // delete1327success
        System.out.println(result);
        return ResponseEntity.ok(result);
    }
}
