package com.zxzxz.shiro.service;

import com.zxzxz.shiro.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lsc
 * @Description <p> 用户服务</p>
 * @Date 2019/11/16 14:22
 */
@Service
public interface UserService {

    /*
     * @Author lsc
     * @Description <p>根据用户名获得用户信息 </p>
     * @Date  2019/11/16 14:23
     * @Param []
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
