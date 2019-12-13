package com.youku1327.quartz.config;

import com.youku1327.quartz.job.SampleJob1;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/10/20 0:56
 * @Version 1.0
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail(){
        JobDetail jobDetail = newJob(SampleJob1.class)
                .withIdentity("job1", "group1")
                .storeDurably()
                .build();
        return jobDetail;
    }

    @Bean
    public CronTrigger cronTrigger(JobDetail jobDetail){

        CronTrigger cronTrigger = newTrigger()
                .forJob(jobDetail)
                .withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("0/10 * * * * ?"))
                .build();
        return cronTrigger;
    }

   /* @Bean
    public Scheduler scheduler(CronTrigger cronTrigger ,JobDetail jobDetail){
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            scheduler= sf.getScheduler();
            scheduler.scheduleJob(jobDetail,cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return scheduler;
    }*/
}
