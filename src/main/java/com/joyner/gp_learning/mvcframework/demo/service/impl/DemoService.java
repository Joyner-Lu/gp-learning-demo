package com.joyner.gp_learning.mvcframework.demo.service.impl;


import com.joyner.gp_learning.mvcframework.core.annotation.GPService;
import com.joyner.gp_learning.mvcframework.demo.dao.IDemoDao;
import com.joyner.gp_learning.mvcframework.demo.service.IDemoService;

/**
 * 核心业务逻辑
 */
@GPService
public class DemoService implements IDemoService {

	private IDemoDao demoDao;

	public String get(String name) {
		demoDao.method();
		return "My name is " + name;

	}

	public IDemoDao getDemoDao() {
		return demoDao;
	}

	public void setDemoDao(IDemoDao demoDao) {
		this.demoDao = demoDao;
	}
}
