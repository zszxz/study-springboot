package com.youku1327.quartz.service;

import org.quartz.JobKey;
import org.springframework.stereotype.Service;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/10/20 0:36
 * @Version 1.0
 */
@Service
public class JobService {

    public void excuteService(JobKey jobName){
        System.out.println("the "+jobName+"  service was excute");
    }
}
