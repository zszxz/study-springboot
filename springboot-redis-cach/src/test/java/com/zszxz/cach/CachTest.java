package com.zszxz.cach;

import com.zszxz.cach.entity.UserEntity;
import com.zszxz.cach.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author lsc
 * <p> </p>
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CachTest {

    @Autowired
    UserService userService;

    @Test
    public void test(){

    }

    @Test
    public void testGet(){
        UserEntity user = userService.getUser(1L);
        System.out.println(user);
    }

    @Test
    public void testPUT(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUser_id(1L);
        userEntity.setUser_name("知识追寻者");
        userEntity.setUser_gender("female");
        userService.updateUser(userEntity);
    }
    @Test
    public void testDel(){
        userService.delUser(4L);
    }

}
