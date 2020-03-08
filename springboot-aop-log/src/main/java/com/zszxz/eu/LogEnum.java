package com.zszxz.eu;

public enum LogEnum {

    UNOPERATE(0,"未定义操作"),
    SELECT(1,"查询"),
    INSERT(2,"添加"),
    UPDATE(3,"更新"),
    DELETE(4,"删除"),
    EXPORT(5,"excel导出"),
    LOGIN(6,"登陆"),
    LOGOUT(7,"登出"),
    ;

    LogEnum( Integer code, String operate) {
        this.operate = operate;
        this.code = code;
    }

    LogEnum(){

    }

    // 操作
    private String operate;
    // 操作码
    private Integer code;

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
