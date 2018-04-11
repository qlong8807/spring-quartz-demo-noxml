package com.java.zz.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zyl
 * @date 2018年4月11日
 * @desc 任务工厂，可以通过任务名或者描述从这里调度不同的任务。
 */
public class QuartzJobFactory implements Job {

	@Autowired
	private Task1 task1;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
		logger.info("任务信息 = [" + scheduleJob.toString() + "]");
		task1.runTask();
	}

}
