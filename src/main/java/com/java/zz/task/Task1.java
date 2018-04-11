package com.java.zz.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.zz.service.AccountService;

@Component(value="task1")
public class Task1 {
	@Autowired
	private AccountService accountService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void runTask() {
		int totalRows = accountService.getTotalRows();
		logger.info("行数："+totalRows);
	}

}
