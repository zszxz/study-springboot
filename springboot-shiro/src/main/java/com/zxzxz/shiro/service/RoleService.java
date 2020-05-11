package com.zxzxz.shiro.service;

import com.zxzxz.shiro.entity.RoleEntity;
import org.springframework.stereotype.Service;

import java.util.List;
/*
 * @Author lsc
 * @Description <p>角色服务 </p>
 * @Date  2019/11/16 15:06
 * @Param
 * @Return
 */
@Service
public interface RoleService {

    /*
     * @Author lsc
     * @Description <p> 根据用户id获得角色列表</p>
     * @Date  2019/11/16 14:52
     * @Param [userId]
     * @Return java.util.List<com.zxzxz.shiro.entity.RoleEntity>
     */
    List<RoleEntity> getRoleByuserId(String userId);
}


