package com.merciqiao.quartz.quartzjob;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Created by MMM on 2017/12/05.
 */
@Getter
@Setter
@Component
public class JobConfig {
    /*任务名称*/
    public String jobName;
    /*任务组名称*/
    public String jobGroupName;
    /*触发器名称*/
    public String triggerName;
    /*触发器组名称*/
    public String triggerGroupName;
    /*cron表达式 */
    public String cron;


}
