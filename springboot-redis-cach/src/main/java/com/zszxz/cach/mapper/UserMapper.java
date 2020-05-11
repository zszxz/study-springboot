package com.zszxz.cach.mapper;

import com.zszxz.cach.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {

    @Insert("INSERT INTO springboot.tb_user(user_name, user_gender) VALUES (#{userEntity.user_name},#{userEntity.user_gender})")
    int addUser(@Param("userEntity") UserEntity userEntity);

    @Select(" select * from tb_user where user_id = #{user_id}")
    @ResultType(UserEntity.class)
    UserEntity getUser(Long user_id);

    @Update("UPDATE tb_user SET user_gender = #{userEntity.user_gender} WHERE user_id=#{userEntity.user_id}")
    int updateUser(@Param("userEntity") UserEntity userEntity);

    @Delete("DELETE FROM tb_user WHERE user_id=#{user_id}")
    int delUser(@Param("user_id") Long user_id);
}
