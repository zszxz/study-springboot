package com.youku1327.quartz.config;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Author lsc
 * @Description <p>统一管理Job 不允许任务并发运行</p>
 * @Date 2019/10/20 0:49
 * @Version 1.0
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class BaseQuartzBean extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // do nothing
    }
}
