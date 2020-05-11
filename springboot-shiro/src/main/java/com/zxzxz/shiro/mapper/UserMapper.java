package com.zxzxz.shiro.mapper;

import com.zxzxz.shiro.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/11/18 11:04
 */
@Repository
@Mapper
public interface UserMapper {

    /*
     * @Author lsc
     * @Description <p> 根据用户名查询用户</p>
     * @Date  2019/11/18 11:05
     * @Param [userName]
     * @Return com.zxzxz.shiro.entity.UserEntity
     */
    UserEntity getUserByuserName(String userName);

    /*
     * @Author lsc
     * @Description <p>添加用户 </p>
     * @Date  2019/11/18 15:41
     * @Param [userEntity]
     * @Return java.lang.Integer
     */
    Integer addUser(UserEntity userEntity);
    /*
     * @Author lsc
     * @Description <p>获得用户列表 </p>
     * @Date  2019/11/19 11:23
     * @Param []
     * @Return java.util.List<com.zxzxz.shiro.entity.UserEntity>
     */
    List<UserEntity> getUserList();
}
