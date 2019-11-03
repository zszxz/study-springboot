package com.youku1327.jdbc.service;

import com.youku1327.jdbc.entity.User;

public interface UserService {

    // 添加
    int addUser(User user);
    // 改
    int updateUser(User user);
    // 删
    int deleteUser(Long id);
    // 通过id查询
    User findUserbyId(Long id);
}
