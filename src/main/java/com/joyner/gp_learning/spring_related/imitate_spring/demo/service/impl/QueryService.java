package com.joyner.gp_learning.spring_related.imitate_spring.demo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;


import com.joyner.gp_learning.spring_related.imitate_spring.demo.service.IQueryService;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.annotation.GPService;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.context.GPAbstractApplicationContext;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.context.GPApplicationContextAware;
import lombok.extern.slf4j.Slf4j;

/**
 * 查询业务
 * @author Tom
 *
 */
@GPService
@Slf4j
public class QueryService implements IQueryService,GPApplicationContextAware {

	/**
	 * 查询
	 */
	public String query(String name) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		String json = "{name:\"" + name + "\",time:\"" + time + "\"}";
		log.info("这是在业务方法中打印的：" + json);
		return json;
	}

	@Override
	public void setApplicationContext(GPAbstractApplicationContext applicationContext) {
		System.out.println("====");
	}
}
