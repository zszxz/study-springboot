package com.zszxz.jpa.repository;

import com.zszxz.jpa.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author lsc
 * <p> </p>
 */
// 接口继承JpaRepository<实体类名,id类型>
public interface SysUserRepository extends JpaRepository<SysUser,Long> {



}
