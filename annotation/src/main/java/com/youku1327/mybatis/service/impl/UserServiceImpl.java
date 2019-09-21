package com.youku1327.mybatis.service.impl;

import com.youku1327.mybatis.entity.UserEntity;
import com.youku1327.mybatis.mapper.UserMapper;
import com.youku1327.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lsc
 * @Description 用户服务层
 * @Date 2019/9/21 0:24
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int addUser(UserEntity userEntity) {
        int count = userMapper.addUser(userEntity);
        return count;
    }

    @Override
    public UserEntity getUsers(Long userId) {
        UserEntity users = userMapper.getUser(userId);
        return users;
    }

    @Override
    public int updateUser(UserEntity userEntity,Long userId) {
        int count = userMapper.updateUser(userEntity,userId);
        return count;
    }

    @Override
    public int delUser(Long userId) {
        int count = userMapper.delUser(userId);
        return count;
    }
}
