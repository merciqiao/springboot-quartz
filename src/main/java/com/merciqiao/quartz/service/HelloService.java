package com.merciqiao.quartz.service;

import org.springframework.stereotype.Component;

/**
 * Created by MMM on 2018/01/22.
 */
@Component
public class HelloService implements IHelloService{
    @Override
    public String getHello(){
        return  "hello";
    }
}
