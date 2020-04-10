package com.zszxz.controller;

import com.zszxz.entity.TbUser;
import com.zszxz.service.TbUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbUser)表控制层
 *
 * @author makejava
 * @since 2020-04-10 16:46:07
 */
@RestController
@RequestMapping("tbUser")
public class TbUserController {
    /**
     * 服务对象
     */
    @Resource
    private TbUserService tbUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbUser selectOne(Long id) {
        return this.tbUserService.queryById(id);
    }

}