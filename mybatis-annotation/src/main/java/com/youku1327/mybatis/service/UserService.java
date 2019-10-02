package com.youku1327.mybatis.service;

import com.youku1327.mybatis.entity.UserEntity;
import org.springframework.stereotype.Service;

/**
 * @Author lsc
 * @Description 用户服务
 * @Date 2019/9/21 0:12
 * @Version 1.0
 */
@Service
public interface UserService {
    /*
     * @Author lsc
     * @Description  // 添加用户
     * @Date 2019/9/21 0:23
     * @Param [userEntity]
     * @return int
     **/
    int addUser(UserEntity userEntity);
    /*
     * @Author lsc
     * @Description  //获得用户
     * @Date 2019/9/21 1:34
     * @Param []
     * @return jUserEntity
     **/
    UserEntity getUsers(Long userId);
    /*
     * @Author lsc
     * @Description  // 修改用户
     * @Date 2019/9/21 14:23
     * @Param [userEntity]
     * @return int
     **/
    int updateUser(UserEntity userEntity,Long userId);
    /*
     * @Author lsc
     * @Description  // 删除用户
     * @Date 2019/9/21 14:24
     * @Param [userId]
     * @return int
     **/
    int delUser(Long userId);
}
