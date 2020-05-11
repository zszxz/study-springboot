package com.zxzxz.shiro.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/*
 * @Author lsc
 * @Description  <p>异常消息 可以参照httpstatus构造，这边是作者随意写的</p>
 * @Date 2019/10/9 20:28
 * @Param
 * @return
 **/
@AllArgsConstructor//全参构造
@NoArgsConstructor//空参构造
public enum CodeMsg {

    SUCESS(200,"sucess"),
    SERVER_ERROR(500,"sorry server error"),
    UNAUTHORIZED(401,"Unauthorized"),
    AUTNORIZED_ERROR(402,"account or password error"),
    Request_Error(404,"the request not fond"),
    PERMISSION_Error(403,"the permission not enough"),
    ACCOUNT_ERROR(405,"account at illegal status"),
    Unknown_ACCOUNT(406,"unknow account");

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
