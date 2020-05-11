package com.zxzxz.shiro.entity;

import lombok.Data;

import java.io.Serializable;


/*
 * @Author lsc
 * @Description <p角色实体> </p>
 * @Date  2019/11/16 14:46
 * @Param
 * @Return
 */
@Data
public class RoleEntity implements Serializable {
	private static final long serialVersionUID = 20191116031327L;
	// 角色ID
	private Long roleId;
	// 角色名称
	private String roleName;
}
