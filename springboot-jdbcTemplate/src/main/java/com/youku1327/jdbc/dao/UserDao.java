package com.youku1327.jdbc.dao;

import com.youku1327.jdbc.entity.User;

/**
 * @Author lsc
 * @Description <p> user dao 接口 </p>
 * @Date 2019/11/2 10:19
 */
public interface UserDao {

    // 添加
    int addUser(User user);
    // 改
    int updateUser(User user);
    // 删
    int deleteUser(Long id);
    // 通过id查询
    User findUserbyId(Long id);


}
