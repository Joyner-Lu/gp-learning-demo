package com.joyner.gp_learning.spring_related.springmvc_mini.demo.service;

import com.joyner.gp_learning.spring_related.springmvc_mini.demo.dao.IDemoDao;
import com.joyner.gp_learning.spring_related.springmvc_mini.demo.dao.impl.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public abstract class AbstractDemoService implements IDemoService {

    @Autowired
    private DemoDao demoDao;

    public String common() {
        return demoDao.mytest1() + "common";
    }
}
