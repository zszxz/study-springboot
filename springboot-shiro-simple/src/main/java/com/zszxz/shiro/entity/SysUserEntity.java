package com.zszxz.shiro.entity;

import lombok.Data;

/**
 * @Author lsc
 * <p> </p>
 */

@Data
public class SysUserEntity {

    // 主键
    private Long id;
    // 账号
    private String username;
    // 名称
    private String name;
    // 密码
    private String password;
    // 盐值
    private String salt;
    // 邮箱
    private String email;
}
