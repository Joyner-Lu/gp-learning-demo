package com.joyner.gp_learning.mvcframework.demo.controller;

import com.joyner.gp_learning.mvcframework.core.annotation.GPAutowired;
import com.joyner.gp_learning.mvcframework.core.annotation.GPController;
import com.joyner.gp_learning.mvcframework.core.annotation.GPRequestMapping;
import com.joyner.gp_learning.mvcframework.core.annotation.GPRequestParam;
import com.joyner.gp_learning.mvcframework.demo.service.IDemoService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@GPController
@GPRequestMapping("/demo")
public class DemoController {

  	@GPAutowired
	private IDemoService demoService;

	@GPRequestMapping("/query")
	public void query(HttpServletRequest req, HttpServletResponse resp,
					  @GPRequestParam("name") String name){
		String result = demoService.get(name);
//		String result = "My name is " + name;
		try {
			resp.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GPRequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp,
					@GPRequestParam("a") Integer a, @GPRequestParam("b") Integer b){
		try {
			resp.getWriter().write(a + "+" + b + "=" + (a + b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GPRequestMapping("/remove")
	public void remove(HttpServletRequest req,HttpServletResponse resp,
					   @GPRequestParam("id") Integer id){
	}

	@GPRequestMapping("/userInfo")
	public String userInfo(){
		return "userInfo[jack]";
	}

}
