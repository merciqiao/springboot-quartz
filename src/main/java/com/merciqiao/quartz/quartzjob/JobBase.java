package com.merciqiao.quartz.quartzjob;

import com.merciqiao.quartz.config.QuartzCronConfig;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by MMM on 2017/12/04.
 */
@Component
@Getter
@Setter
@Slf4j
public abstract class JobBase implements Job {
    @Autowired
    public QuartzCronConfig quartzCronConfig;
    public abstract JobConfig getJobConfig();
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("执行定时任务");
    }
}
