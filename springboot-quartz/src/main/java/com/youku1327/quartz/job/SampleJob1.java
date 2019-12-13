package com.youku1327.quartz.job;

import com.youku1327.quartz.config.BaseQuartzBean;
import com.youku1327.quartz.service.JobService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/10/20 0:31
 * @Version 1.0
 */
@Component
public class SampleJob1 extends BaseQuartzBean {

    @Autowired
    JobService jobService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        jobService.excuteService(jobExecutionContext.getJobDetail().getKey());
    }
}
