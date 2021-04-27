package com.config;

import com.module.test.po.Test;
import com.module.test.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private TestServiceImpl service;

    public void onApplicationEvent(ApplicationReadyEvent arg0) {
        System.out.println("Spring容器启动好了...");
        service.selectTestList(new Test());
    }
}
