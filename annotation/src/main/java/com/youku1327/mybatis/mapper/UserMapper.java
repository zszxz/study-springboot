package com.youku1327.mybatis.mapper;

import com.youku1327.mybatis.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @Author lsc
 * @Description
 * @Date 2019/9/21 0:13
 * @Version 1.0
 */
@Mapper
@Repository
public interface UserMapper  {

    @Insert("INSERT INTO `springboot`.`tb_user`(`user_name`, `user_gender`) VALUES (#{userEntity.userName},#{userEntity.userGender})")
    int addUser(@Param("userEntity") UserEntity userEntity);

    @Select(" select * from `tb_user` where `user_id` = #{userId}")
    @ResultType(UserEntity.class)
    UserEntity getUser(Long userId);

    @Update("UPDATE `tb_user` SET user_telephone = #{userEntity.userTelephone} WHERE `user_id`=#{userId}")
    int updateUser(@Param("userEntity") UserEntity userEntity,@Param("userId") Long userId);

    @Delete("DELETE FROM `tb_user` WHERE `user_id`=#{userId}")
    int delUser(@Param("userId")Long userId);
}
