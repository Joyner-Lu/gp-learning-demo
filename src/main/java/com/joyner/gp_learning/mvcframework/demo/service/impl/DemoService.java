package com.joyner.gp_learning.mvcframework.demo.service.impl;


import com.joyner.gp_learning.mvcframework.core.annotation.GPService;
import com.joyner.gp_learning.mvcframework.demo.service.IDemoService;

/**
 * 核心业务逻辑
 */
@GPService
public class DemoService implements IDemoService {

	public String get(String name) {
		return "My name is " + name;
	}

}
