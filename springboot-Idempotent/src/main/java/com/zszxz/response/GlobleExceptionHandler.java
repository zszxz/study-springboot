package com.zszxz.response;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @Author lsc
 * @Description  <p> 异常捕获</p>
 * @Date 2019/10/9 20:42
 * @Param
 * @return
 **/
@ControllerAdvice
@Configuration
public class GlobleExceptionHandler {


    // 捕获CommonException异常
    @ExceptionHandler(value = GlobleException.class)
    @ResponseBody
    public ResponseEntity<ResultPage> CommonExceptionHandler(GlobleException e){
        // 获得异常消息
        CodeMsg codeMsg = e.getCodeMsg();
        // 设置错误消息页面返回
        return ResponseEntity.status(HttpStatus.OK).body(ResultPage.error(codeMsg));
    }

}
