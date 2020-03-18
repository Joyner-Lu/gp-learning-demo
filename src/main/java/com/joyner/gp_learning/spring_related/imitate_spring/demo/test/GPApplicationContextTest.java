package com.joyner.gp_learning.spring_related.imitate_spring.demo.test;

import com.joyner.gp_learning.spring_related.imitate_spring.demo.action.MyAction;
import com.joyner.gp_learning.spring_related.imitate_spring.demo.service.IModifyService;
import com.joyner.gp_learning.spring_related.imitate_spring.demo.service.impl.ModifyService;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.context.GPApplicationContext;

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
public class GPApplicationContextTest {

    public static void main(String[] args) {
        GPApplicationContext applicationContext = new GPApplicationContext("/application.properties");
        MyAction myAction = applicationContext.getBean(MyAction.class);
        System.out.println(myAction);


    }
}
