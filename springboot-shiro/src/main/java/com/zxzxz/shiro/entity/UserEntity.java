package com.zxzxz.shiro.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 系统用户实体
 * @Author Sans
 * @CreateTime 2019/6/14 15:57
 */
@Data
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 201911061327L;

	// id
	private Long id;
	// 用户id
	private String userId;
	// 用户名
	private String userName;
	// 密码
	private String password;
	// 盐值
	private String salt;
	// 状态
	private String state;

}
