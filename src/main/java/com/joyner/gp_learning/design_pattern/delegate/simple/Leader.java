package com.joyner.gp_learning.design_pattern.delegate.simple;

import java.util.HashMap;
import java.util.Map;

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
public class Leader implements IEmployee {

    private static Map<String, IEmployee> targets = new HashMap<>();

    static {
        /**
         * leader要了解自己的手下情况
         */
        targets.put("加密", new EmployeeA());
        targets.put("架构", new EmployeeB());
    }


    @Override
    public void doing(String command) {
        //项目经理不干活，委派给最合适的人
        targets.get(command).doing(command);
    }
}
