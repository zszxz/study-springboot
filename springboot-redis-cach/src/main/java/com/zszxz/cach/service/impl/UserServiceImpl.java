package com.zszxz.cach.service.impl;

import com.zszxz.cach.entity.UserEntity;
import com.zszxz.cach.mapper.UserMapper;
import com.zszxz.cach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author lsc
 * <p> 缓存的key。可以使用SpEl表达式</p>
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /* *
     * @Author lsc
     * <p>先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中
     * unless 表示条件表达式成立的话不放入缓存
     * 如果 设置 ,keyGenerator = "keyGenerator" 就不能设置 key
     *  </p>
     * @Param [user_id]
     * @Return com.zszxz.cach.entity.UserEntity
     */
    @Override
    @Cacheable(cacheNames = "UserEntity", key = "#user_id")
    public UserEntity getUser(Long user_id) {
        return userMapper.getUser(user_id);
    }


    @Override
    public int addUser(UserEntity userEntity) {
        return 0;
    }

    /* *
     * @Author lsc
     * <p>修改了数据库的数据，同时更新缓存。先调用目标方法，然后缓存方法结果 </p>
     * @Param [userEntity]
     * @Return int
     */
    @Override
    @CachePut(cacheNames = "UserEntity", key = "#result.user_id")
    public UserEntity updateUser(UserEntity userEntity) {
        userMapper.updateUser(userEntity);
        // 注意，会将缓存更新未参数userEntity里面的值
        return userEntity;
    }

    /* *
     * @Author lsc
     * <p>allEntries 是否清空所有缓存内容，缺省为 false，如果指定为 true，则方法调用后将立即清空所有缓存
     * 指定删除一条缓存
     * </p>
     * @Param [user_id]
     * @Return int
     */
    @Override
    @CacheEvict(cacheNames = "UserEntity", key = "#user_id")
    public int delUser(Long user_id) {
        return userMapper.delUser(user_id);
    }
}
