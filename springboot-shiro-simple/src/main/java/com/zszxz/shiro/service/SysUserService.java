package com.zszxz.shiro.service;

import com.zszxz.shiro.entity.SysUserEntity;

public interface SysUserService {

    /* *
     * @Author lsc
     * <p> 通过用户名获取用户信息</p>
     * @Param [username]
     */
    SysUserEntity getUserByUserName(String username);

    void addSysUser(SysUserEntity sysUserEntity);
}
