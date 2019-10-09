package com.youku1327.excetion.advice;

import com.youku1327.excetion.response.CodeMsg;
import com.youku1327.excetion.response.CommonException;
import com.youku1327.excetion.response.ResultPage;
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
public class CommonExceptionHandler {


    // 捕获CommonException异常
    @ExceptionHandler(value = CommonException.class)
    @ResponseBody
    public ResponseEntity<ResultPage> CommonExceptionHandler(CommonException e){
        // 获得异常消息
        CodeMsg codeMsg = e.getCodeMsg();
        // 设置错误消息页面返回
        return ResponseEntity.status(HttpStatus.OK).body(ResultPage.error(codeMsg));
    }

    // 下面还可以自定义捕获其他异常比如 非法参数异常 运算异常 等等.......

}
