package com.youku1327.jdbc.dao.impl;

import com.youku1327.jdbc.dao.UserDao;
import com.youku1327.jdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author lsc
 * @Description <p> user 持久层 </p>
 * @Date 2019/11/2 10:22
 */
@Repository
public class UserDaoImpl implements UserDao {

    // 注入jdbc模板
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addUser(User user) {
        // sql
        String sql = "insert into user (name,telephone) values (?,?)";
        // jdbc insert
        return jdbcTemplate.update(sql,user.getName(),user.getTelephone());
    }

    @Override
    public int updateUser(User user) {
        // sql
        String sql = "update user set name = ?, telephone = ? where id = ?";
        // jdbc updae
        return jdbcTemplate.update(sql,user.getName(),user.getTelephone(),user.getId());
    }

    @Override
    public int deleteUser(Long id) {
        // sql
        String sql = "delete from user where id = ?";
        // delete
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public User findUserbyId(Long id) {
        // sql
        String sql = "select * from user where id = ?";
        // params
        Object[] params = new Object[]{id};
        // rowMapper
        BeanPropertyRowMapper rowMapper = new BeanPropertyRowMapper(User.class);
        // jdbc query
        List<User> query = jdbcTemplate.query(sql, params, rowMapper);
        // return user
        return query.get(0);
    }
}
