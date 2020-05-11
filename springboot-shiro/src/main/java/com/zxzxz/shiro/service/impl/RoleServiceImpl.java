package com.zxzxz.shiro.service.impl;

import com.zxzxz.shiro.entity.RoleEntity;
import com.zxzxz.shiro.mapper.RoleMapper;
import com.zxzxz.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/11/18 9:24
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<RoleEntity> getRoleByuserId(String userId) {
        return roleMapper.getRoleByuserId(userId);
    }
}
