package com.zszxz.cach.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author lsc
 * <p> </p>
 */
@Data
public class UserEntity implements Serializable {

    private Long user_id;

    private String user_name;

    private String user_gender;

    private String user_telephone;
}
