package com.java.zz.task;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component
public class MyJobFactory extends AdaptableJobFactory {

	//这个对象Spring会帮我们自动注入进来.
	@Autowired
	private AutowireCapableBeanFactory capableBeanFactory;
	
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		//调用父类的方法
		Object jobInstance = super.createJobInstance(bundle);
		//进行注入.
		capableBeanFactory.autowireBean(jobInstance);
		return jobInstance;
	}
}
