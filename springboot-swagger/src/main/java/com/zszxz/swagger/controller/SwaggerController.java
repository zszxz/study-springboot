package com.zszxz.swagger.controller;

import com.zszxz.swagger.entity.ZSZXZ;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author lsc
 * <p> </p>
 */
@RestController
// 资源信息
@Api(value = "知识追寻者文档API")
public class SwaggerController {

    // 方法注释
    @ApiOperation(value = "获取用户")
    // 响应信息
    @ApiResponse(code = 200,message = "获取用户列表成功")
    @GetMapping("zszxz")
    public ResponseEntity getUser(){
        ZSZXZ zszxz = new ZSZXZ();
        zszxz.setName("知识追寻者");
        zszxz.setHobby("爱睡觉");
        zszxz.setEmail("不告诉你");
        return ResponseEntity.ok(zszxz);
    }

    // 方法注释
    @ApiOperation(value = "跟据用户编号获取用户")
    // 响应信息
    @ApiResponses({@ApiResponse(code = 200,message = "获取用户列表成功")
                    ,@ApiResponse(code = 204,message = "没有内容")})
    // 参数信息
    @ApiImplicitParam(name = "id", value = "用户编号", dataType = "ZSZXZ",required = true, paramType = "path")
    @GetMapping("zszxz/{id}")
    public ResponseEntity getUserById(@PathVariable Long id){
        ZSZXZ zszxz = new ZSZXZ();
        zszxz.setName("知识追寻者");
        zszxz.setHobby("爱睡觉");
        zszxz.setEmail("不告诉你");
        return ResponseEntity.ok(zszxz);
    }

    @PostMapping("zszxz")
    // 响应信息
    @ApiResponse(code = 201,message = "添加用户列表成功")
    // 方法信息
    @ApiOperation(value = "添加用户")
    public ResponseEntity addUser(@RequestBody ZSZXZ zszxz){

        System.out.println("save the user:"+zszxz);
        return ResponseEntity.ok("success save the user");
    }

    // 响应信息
    @ApiResponse(code = 200,message = "修改用户成功")
    @ApiOperation(value = "修改用户",notes = "修改用户")
    @PutMapping("zszxz/{id}")
    // 参数信息 多个参数使用注释中得内容, @RequestBody 修斯参数没必要写
    /*@ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户编号", dataType = "Long",required = true,paramType = "path")
    ,@ApiImplicitParam(name = "user", value = "用户", dataType = "ZSZXZ",required = true, paramType = "json")})*/
    @ApiImplicitParam(name = "id", value = "用户编号", dataType = "Long",required = true,paramType = "path")
    public ResponseEntity updateUser(@PathVariable Long id ,@RequestBody ZSZXZ zszxz){

        System.out.println("update the user:"+zszxz);
        return ResponseEntity.ok("success update the user,the number is :"+id);
    }


    // 响应信息
    @ApiResponses({@ApiResponse(code = 200,message = "删除用户成功")
            ,@ApiResponse(code = 401,message = "没有权限")
            })
    @ApiOperation(value = "删除用户")
    @DeleteMapping("zszxz/{id}")
    @ApiImplicitParam(name = "id", value = "用户编号", dataType = "Long",required = true,paramType = "path")
    public ResponseEntity updateUser(@PathVariable Long id ){
        System.out.println("delete the user :"+id);
        return ResponseEntity.ok("delete the user :"+id);
    }



}
