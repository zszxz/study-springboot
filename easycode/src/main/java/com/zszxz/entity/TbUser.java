package com.zszxz.entity;

import java.io.Serializable;

/**
 * (TbUser)实体类
 *
 * @author makejava
 * @since 2020-04-10 16:46:05
 */
public class TbUser implements Serializable {
    private static final long serialVersionUID = -13598178616509399L;
    
    private Long userId;
    
    private String userName;
    
    private String userGender;
    
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