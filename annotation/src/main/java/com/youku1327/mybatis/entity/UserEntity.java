package com.youku1327.mybatis.entity;

/**
 * @Author lsc
 * @Description 用户实体
 * @Date 2019/9/20 23:58
 * @Version 1.0
 */
public class UserEntity {

    // 用户id
    private Long userId;
    // 用户名称
    private String userName;
    // 用户性别
    private String userGender;
    // 用户电话
    private String userTelephone;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }
}
