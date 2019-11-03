package com.youku1327.jdbc.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @Author lsc
 * @Description <p> 实现spring bean 生命周期接口</p>
 * @Date 2019/11/2 10:08
 */
@Component
public class DatabaseVision implements ApplicationContextAware {

    ApplicationContext applicationContext = null;
    // spring ioc 初始化 bean 的时候调用
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 获得applicationContext
        this.applicationContext = applicationContext;
        // 获得dataSource
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        // 启动 springboot application print com.alibaba.druid.pool.DruidDataSource
        System.out.println(dataSource.getClass().getName());
    }
}
