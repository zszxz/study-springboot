package com.zxzxz.shiro.service.impl;

import com.zxzxz.shiro.entity.PowerEntity;
import com.zxzxz.shiro.mapper.PowerMapper;
import com.zxzxz.shiro.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/11/19 9:39
 */
@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    PowerMapper powerMapper;

    @Override
    public List<PowerEntity> getPowerByRoleId(Long roleId) {
        return powerMapper.getPowerByRoleId(roleId);
    }
}
