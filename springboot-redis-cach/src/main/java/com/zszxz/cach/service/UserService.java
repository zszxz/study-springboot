package com.zszxz.cach.service;

import com.zszxz.cach.entity.UserEntity;

/**
 * @Author lsc
 * <p> </p>
 */
public interface UserService {

    UserEntity getUser(Long user_id);

    int addUser(UserEntity userEntity);

    UserEntity updateUser(UserEntity userEntity);

    int delUser(Long user_id);
}
