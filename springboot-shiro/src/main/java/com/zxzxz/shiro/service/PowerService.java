package com.zxzxz.shiro.service;

import com.zxzxz.shiro.entity.PowerEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PowerService {
    /*
     * @Author lsc
     * @Description <p> 通过角色id得权限</p>
     * @Date  2019/11/19 9:35
     * @Param [roleId]
     * @Return java.util.List<com.zxzxz.shiro.entity.PowerEntity>
     */
    List<PowerEntity> getPowerByRoleId(Long roleId);

}
