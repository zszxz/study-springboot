package com.youku1327.jdbc.service.impl;

import com.youku1327.jdbc.dao.UserDao;
import com.youku1327.jdbc.entity.User;
import com.youku1327.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lsc
 * @Description <p> user service </p>
 * @Date 2019/11/2 10:37
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User findUserbyId(Long id) {
        return userDao.findUserbyId(id) ;
    }
}
