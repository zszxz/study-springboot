package com.zszxz.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author lsc
 * <p> </p>
 */
@Entity
@Setter
@Getter
@Table(name="sys_user")
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String lastName;

    private String firstName;

    private String address;
}
