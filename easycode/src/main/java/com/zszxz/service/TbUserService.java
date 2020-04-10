package com.zszxz.service;

import com.zszxz.entity.TbUser;
import java.util.List;

/**
 * (TbUser)表服务接口
 *
 * @author makejava
 * @since 2020-04-10 16:46:07
 */
public interface TbUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    TbUser queryById(Long id );

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    TbUser insert(TbUser tbUser);

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    TbUser update(TbUser tbUser);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    boolean deleteById( );

}