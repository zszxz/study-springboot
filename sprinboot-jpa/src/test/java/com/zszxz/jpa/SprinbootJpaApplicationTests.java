package com.zszxz.jpa;

import com.zszxz.jpa.entity.SysUser;
import com.zszxz.jpa.repository.SysUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SprinbootJpaApplicationTests {

    @Autowired
    SysUserRepository sysUserRepository;

    @Test
    public void contextLoads() {

        Optional<SysUser> byId = sysUserRepository.findById(1L);
        // efghijklmnopq
        System.out.println(byId.get().getFirstName());
    }

}
