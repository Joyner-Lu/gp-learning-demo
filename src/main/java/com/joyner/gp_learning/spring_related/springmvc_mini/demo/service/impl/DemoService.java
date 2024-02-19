package com.joyner.gp_learning.spring_related.springmvc_mini.demo.service.impl;


import com.joyner.gp_learning.spring_related.springmvc_mini.core.annotation.GPService;
import com.joyner.gp_learning.spring_related.springmvc_mini.demo.dao.IDemoDao;
import com.joyner.gp_learning.spring_related.springmvc_mini.demo.service.AbstractDemoService;
import com.joyner.gp_learning.spring_related.springmvc_mini.demo.service.IDemoService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 核心业务逻辑
 */
@GPService
public class DemoService extends AbstractDemoService implements ApplicationContextAware {

	@Autowired
	private IDemoDao demoDao;

	public String get(String name) {
		demoDao.method();
		System.out.println("parent");
		common();
		return "My name is " + name;

	}

	public IDemoDao getDemoDao() {
		return demoDao;
	}

	public void setDemoDao(IDemoDao demoDao) {
		this.demoDao = demoDao;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("");
	}
}
