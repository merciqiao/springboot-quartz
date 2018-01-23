package com.merciqiao.quartz.quartzjob.jobs;

import com.merciqiao.quartz.config.QuartzCronConfig;
import com.merciqiao.quartz.quartzjob.JobBase;
import com.merciqiao.quartz.quartzjob.JobConfig;
import com.merciqiao.quartz.service.IHelloService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
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
@DisallowConcurrentExecution //设置不能同时执行同一个job
@Slf4j
public class JobDemo extends JobBase {
    //private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    IHelloService helloService;
    @Autowired
    QuartzCronConfig quartzCronConfig;
    @Override
    public JobConfig getJobConfig(){
        JobConfig jobConfig=new JobConfig();
        jobConfig.jobName="job01";
        jobConfig.jobGroupName="job-group01";
        jobConfig.triggerName="trigger01";
        jobConfig.triggerGroupName="trigger-group01";
        jobConfig.cron=quartzCronConfig.getJobdemocron();
        return  jobConfig;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String str= helloService.getHello();
        log.info("JobDemo.execute:"+str);
    }
}
