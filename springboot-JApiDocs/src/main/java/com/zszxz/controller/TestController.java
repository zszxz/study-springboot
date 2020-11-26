package com.zszxz.controller;

import com.zszxz.entity.TestVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author lsc
 * <p>测试 </p>
 */
@RestController
public class TestController {

   /**
    * 测试get
    * @param testVo
    */
    @GetMapping(value = "info")
    public ResponseEntity<TestVo> testGet(TestVo testVo){
        return ResponseEntity.ok().body(testVo);
    }

    /**
     * 测试get参数
     * @param id
     */
    @GetMapping(value = "info/test")
    public ResponseEntity<Long> test(@RequestParam Long id){
        return ResponseEntity.ok().body(id);
    }

    /**
     * 测试post
     * @param testVo
     */
    @PostMapping(value = "info")
    public ResponseEntity<Long> testPost(@RequestBody TestVo testVo){
        return ResponseEntity.ok().body(1L);
    }

    /**
     * 测试delete
     * @param id
     */
    @DeleteMapping(value = "info/{id}")
    public ResponseEntity<Long> testPost(@PathVariable Long id){
        return ResponseEntity.ok().body(1L);
    }



}
