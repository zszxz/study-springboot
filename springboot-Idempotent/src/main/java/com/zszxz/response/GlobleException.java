package com.zszxz.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author lsc
 * @Description <p>自定义通用异常 </p>
 * @Date 2019/10/9 20:39
 * @Version 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GlobleException extends RuntimeException {

    // 序列化号
    private static final long serialVersionUID = 132719492019L;

    // 引入自定义异常消息
    private CodeMsg codeMsg;


}
