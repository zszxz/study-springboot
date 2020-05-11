package com.zxzxz.shiro.mapper;

import com.zxzxz.shiro.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleMapper {

    /*
     * @Author lsc
     * @Description <p> 根据用户id获得角色列表</p>
     * @Date  2019/11/16 14:52
     * @Param [userId]
     * @Return java.util.List<com.zxzxz.shiro.entity.RoleEntity>
     */
    List<RoleEntity> getRoleByuserId(String userId);
}
