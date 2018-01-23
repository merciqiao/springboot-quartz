package com.merciqiao.quartz.quartzjob;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by MMM on 2017/12/04.
 */
@Component
@Slf4j
public class JobFactory {
    @Autowired
    private List<JobBase> jobList;
    @Autowired
    JobFactoryConfiguration jobFactoryConfiguration;
    @PostConstruct
    public void init() throws Exception {
        if (jobList != null && jobList.size() > 0) {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //add by qlx 添加jobfactory
            scheduler.setJobFactory(jobFactoryConfiguration);
            scheduler.start();

            for (JobBase job : jobList) {
                JobConfig jobConfig = job.getJobConfig();
                JobDetail jobDetail = newJob(job.getClass())
                        .withIdentity(jobConfig.jobName, jobConfig.jobGroupName)
                        .build();
                CronTrigger cronTrigger = newTrigger()
                        .withIdentity(jobConfig.triggerName, jobConfig.triggerGroupName)
                        .withSchedule(cronSchedule(jobConfig.cron))
                        .build();
                Date ft = scheduler.scheduleJob(jobDetail, cronTrigger);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
                log.info("quartz-job:" + jobDetail.getKey()
                        + " turn on at: " + sdf.format(ft)
                        + "，the cron is: "
                        + cronTrigger.getCronExpression());
            }

        }
    }
}
