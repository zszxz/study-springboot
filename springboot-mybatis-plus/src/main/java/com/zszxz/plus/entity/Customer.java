package com.zszxz.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author lsc
 * <p> </p>
 */
@Data
@TableName("customer")// 映射数据库表名
public class Customer {
    //主键
    @TableId(type = IdType.AUTO)
    private Long id;

    // 如果字段和数据库列意指可省略该注解
    // @TableField(value = "NAME",exist = true)
    private String customerName;

    private String gender;

    private String telephone;

    private String registerTime;
}
