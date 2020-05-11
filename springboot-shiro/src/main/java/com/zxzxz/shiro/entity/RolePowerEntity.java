package com.zxzxz.shiro.entity;

import lombok.Data;

import java.io.Serializable;


/*
 * @Author lsc
 * @Description <p>角色与菜单关系实体 </p>
 * @Date  2019/11/16 14:48
 * @Param
 * @Return
 */
@Data
public class RolePowerEntity implements Serializable {
	private static final long serialVersionUID = 201911160041327L;
	// id
	private Long id;
	// 角色id
	private Long roleId;
	// 权限id
	private Long powerId;
}
