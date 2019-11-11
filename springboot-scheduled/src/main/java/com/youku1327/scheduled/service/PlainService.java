package com.youku1327.scheduled.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/11/11 22:23
 */
@Service
public class PlainService {

    @Scheduled(cron = "30 * * * * ?")
    public void cronScheduled(){
        //System.out.println("关注作者博客和公众号，不定期分享原创文章");
    }


    @Scheduled(fixedDelay = 3000)
    public void fixedDelayScheduled(){
        //System.out.println("the day nice");
    }

    @Scheduled(fixedRate = 3000)
    public void fixedRateScheduled(){
       // System.out.println("the night nice");
    }

    @Scheduled(initialDelay = 1000,fixedRate = 3000)
    public void initialDelayStringScheduled(){
        System.out.println("the night nice");
    }

}
