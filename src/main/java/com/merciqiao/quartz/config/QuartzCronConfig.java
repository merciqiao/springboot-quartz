package com.merciqiao.quartz.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by MMM on 2017/12/05.
 */
@Component
@ConfigurationProperties(prefix = "quartzcron-config")
@Getter
@Setter
public class QuartzCronConfig {
    public String jobdemocron;
}
