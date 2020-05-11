package com.zxzxz.shiro.entity;

import lombok.Data;

import java.io.Serializable;


/*
 * @Author lsc
 * @Description <p> 用户和角色关联</p>
 * @Date  2019/11/16 14:43
 */
@Data
public class UserRoleEntity implements Serializable {
	private static final long serialVersionUID = 20191116011327L;
	// di
	private Long id;
	// 用户id
	private Long userId;
	// 角色id
	private Long roleId;
}
