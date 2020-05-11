package com.zxzxz.shiro.mapper;

import com.zxzxz.shiro.entity.PowerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PowerMapper {

    /*
     * @Author lsc
     * @Description <p> 通过角色id得权限</p>
     * @Date  2019/11/19 9:35
     * @Param [roleId]
     * @Return java.util.List<com.zxzxz.shiro.entity.PowerEntity>
     */
    List<PowerEntity> getPowerByRoleId(Long roleId);
}
