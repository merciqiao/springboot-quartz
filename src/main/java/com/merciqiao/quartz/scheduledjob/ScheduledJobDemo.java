package com.merciqiao.quartz.scheduledjob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by MMM on 2018/01/22.
 */
@Component
@EnableScheduling
@Slf4j
public class ScheduledJobDemo {
    @Scheduled(fixedRate = 5000)//每5秒执行一次,测试用
    public void job(){
        log.info("ScheduledJobDemo.job:word");
    }
}
