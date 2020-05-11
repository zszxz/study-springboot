package com.zxzxz.shiro.entity;

import lombok.Data;

/**
 * @Author lsc
 * @Description <p> 权限实体 </p>
 * @Date 2019/11/19 9:30
 */
@Data
public class PowerEntity {

    // 主键
    private Long id;
    // 权限类型
    private String powerType;
    // 权限名称
    private String powerName;
    // 权限
    private String power;
}
