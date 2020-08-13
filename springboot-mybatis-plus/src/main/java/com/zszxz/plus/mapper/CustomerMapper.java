package com.zszxz.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zszxz.plus.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author lsc
 * <p> </p>
 */
@Repository
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {


}
