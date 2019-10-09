package com.youku1327.excetion.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lsc
 * @Description <p>自定义通用异常 </p>
 * @Date 2019/10/9 20:39
 * @Version 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonException extends RuntimeException {

    // 序列化号
    private static final long serialVersionUID = 132719492019L;

    // 引入自定义异常消息
    private CodeMsg codeMsg;


}
