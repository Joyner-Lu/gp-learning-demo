package com.joyner.gp_learning.spring_related.springmvc_mini.demo.dao.impl;

import com.joyner.gp_learning.spring_related.springmvc_mini.demo.dao.IDemoDao;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class DemoDao implements IDemoDao {

    @Override
    public void method() {
        System.out.println("DAO method.");
        if (1 == 1) {
            //throw new RuntimeException("故意搞的异常");
        }
    }
}
