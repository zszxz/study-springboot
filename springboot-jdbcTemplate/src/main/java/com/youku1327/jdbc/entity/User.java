package com.youku1327.jdbc.entity;

/**
 * @Author lsc
 * @Description <p>pojo </p>
 * @Date 2019/11/2 10:16
 */
public class User {

    // id
    private Long id;
    // 姓名
    private String name;
    // 电话
    private String telephone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
