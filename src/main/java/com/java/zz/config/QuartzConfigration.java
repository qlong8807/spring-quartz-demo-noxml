package com.java.zz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.java.zz.task.MyJobFactory;

@Configuration
public class QuartzConfigration {
	
	@Autowired
	private MyJobFactory myJobFactory;
	
	/** 
     * attention: 
     * Details：定义quartz调度工厂 
     */  
    @Bean(name = "schedulerFactoryBean")  
    public SchedulerFactoryBean schedulerFactory() {  
        SchedulerFactoryBean bean = new SchedulerFactoryBean();  
        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job  
        bean.setOverwriteExistingJobs(true);  
        // 延时启动，应用启动1秒后  
        bean.setStartupDelay(1);  
        bean.setJobFactory(myJobFactory);
        return bean;
    }

}
