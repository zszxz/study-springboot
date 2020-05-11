package com.zxzxz.shiro.service.impl;

import com.zxzxz.shiro.entity.UserEntity;
import com.zxzxz.shiro.mapper.UserMapper;
import com.zxzxz.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lsc
 * @Description <p> 用户服务</p>
 * @Date 2019/11/18 9:23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserEntity getUserByuserName(String userName) {
        return userMapper.getUserByuserName(userName);
    }

    @Override
    public Integer addUser(UserEntity userEntity) {
        return userMapper.addUser(userEntity);
    }

    @Override
    public List<UserEntity> getUserList() {
        return userMapper.getUserList();
    }
}
