package com.joyner.gp_learning.spring_related.imitate_spring.demo.action;


import com.joyner.gp_learning.spring_related.imitate_spring.demo.service.IModifyService;
import com.joyner.gp_learning.spring_related.imitate_spring.demo.service.IQueryService;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.annotation.GPAutowired;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.annotation.GPController;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.annotation.GPRequestMapping;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.annotation.GPRequestParam;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.web.servlet.GPModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 公布接口url
 * @author Tom
 *
 */
@GPController
@GPRequestMapping("/web")
public class MyAction {

	@GPAutowired
	IQueryService queryService;
	@GPAutowired
	IModifyService modifyService;

	@GPRequestMapping("/query.json")
	public GPModelAndView query(HttpServletRequest request, HttpServletResponse response,
								@GPRequestParam("name") String name){
		String result = queryService.query(name);
		return out(response,result);
	}
	
	@GPRequestMapping("/add*.json")
	public GPModelAndView add(HttpServletRequest request,HttpServletResponse response,
			   @GPRequestParam("name") String name,@GPRequestParam("addr") String addr){
		String result = null;
		try {
			result = modifyService.add(name,addr);
			return out(response,result);
		} catch (Exception e) {
//			e.printStackTrace();
			Map<String,Object> model = new HashMap<String,Object>();
			model.put("detail",e.getMessage());
//			System.out.println(Arrays.toString(e.getStackTrace()).replaceAll("\\[|\\]",""));
			model.put("stackTrace", Arrays.toString(e.getStackTrace()).replaceAll("\\[|\\]",""));
			return new GPModelAndView("500",model);
		}

	}
	
	@GPRequestMapping("/remove.json")
	public GPModelAndView remove(HttpServletRequest request,HttpServletResponse response,
								 @GPRequestParam("id") Integer id){
		String result = modifyService.remove(id);
		return out(response,result);
	}

	@GPRequestMapping("/first")
	public GPModelAndView first(HttpServletRequest request,HttpServletResponse response){
		/**
		 * <h1>大家好，我是￥{teacher}老师<br/>欢迎大家一起来探索Spring的世界</h1>
		 * 	<h3>Hello,My name is ￥{teacher}</h3>
		 * 	<div>￥{data}</div>
		 * 	Token值：￥{token}
		 */
		String teacher = request.getParameter("teacher");
		Map<String,Object> model = new HashMap<>();
		model.put("teacher", teacher == null? "default_teacher" : teacher);
		model.put("data", "this is data");
		model.put("token", "tokenVal ue");

		GPModelAndView modelAndView = new GPModelAndView("first");
		modelAndView.setModel(model);
		return modelAndView;
	}
	
	@GPRequestMapping("/edit.json")
	public GPModelAndView edit(HttpServletRequest request,HttpServletResponse response,
			@GPRequestParam("id") Integer id,
			@GPRequestParam("name") String name){
		String result = modifyService.edit(id,name);
		return out(response,result);
	}
	
	
	
	private GPModelAndView out(HttpServletResponse resp,String str){
		try {
			resp.getWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
