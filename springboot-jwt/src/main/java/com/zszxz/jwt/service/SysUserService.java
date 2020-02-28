package com.zszxz.jwt.service;

import org.springframework.stereotype.Service;

/**
 * @Author lsc
 * <p> 模拟查询数据库获得账号密码 </p>
 */
@Service
public class SysUserService {


    public String getPassword(){
        return "zszxz";
    }
}
