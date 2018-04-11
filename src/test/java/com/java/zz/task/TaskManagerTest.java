package com.java.zz.task;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath*:spring-mvc.xml", "classpath*:spring-other.xml" })
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskManagerTest {
	
	@Autowired
	private TaskManager taskManager;
	
	@Before
	public void before() {
		
	}

	/**
	 * 5秒打印一次，共打印2次；停10秒；继续5秒打印一次，打印2次；2秒打印一次，打印5次。
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		ScheduleJob job = new ScheduleJob();
		job.setJobId("1");
		job.setJobName("job1");
		job.setJobGroup("jobgroup1");
		job.setJobStatus("0");
		job.setCronExpression("0/5 * * * * ?");
		job.setDesc("hahahah");
		taskManager.createJob(job);
		List<ScheduleJob> planJob = taskManager.getPlanJob();
		for(ScheduleJob job2 : planJob) {
			System.err.println("planJob:"+job2.toString());
		}
		List<ScheduleJob> runJob = taskManager.getRunningJob();
		for(ScheduleJob job2 : runJob) {
			System.err.println("planJob:"+job2.toString());
		}
		Thread.sleep(10000);
		
		taskManager.pauseJob(job);
		
		Thread.sleep(10000);
		
		taskManager.resumeJob(job);
		
		Thread.sleep(10000);
		
		job.setCronExpression("0/2 * * * * ?");
		job.setDesc("bbbbbbbbbb");
		
		taskManager.reshedule(job);

		Thread.sleep(10000);
	}

}
