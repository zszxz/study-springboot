package com.youku1327.excetion.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/*
 * @Author lsc
 * @Description  <p>异常消息 </p>
 * @Date 2019/10/9 20:28
 * @Param
 * @return
 **/
@AllArgsConstructor//全参构造
@NoArgsConstructor//空参构造
public enum CodeMsg {

    SUCESS(200,"sucess"),
    SERVER_ERROR(500,"服务端异常"),
    Request_Error(404,"请求异常");

    // 错误消息码
    private Integer code;
    // 错误消息提示
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
