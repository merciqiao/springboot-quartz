package com.merciqiao.quartz.quartzjob;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * Created by MMM on 2017/12/07.
 */
@Component
public class JobFactoryConfiguration extends AdaptableJobFactory {

    @Autowired
    AutowireCapableBeanFactory capableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {

        /**
         * 这里覆盖了super的createJobInstance方法，对其创建出来的类再进行autowire。
         */
        Object jobInstance = super.createJobInstance(bundle);
        //进行spring注入
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}