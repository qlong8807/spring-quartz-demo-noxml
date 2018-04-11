package com.java.zz.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

	@Override
	public int getTotalRows() {
		return new Random().nextInt(1000);
	}

}
