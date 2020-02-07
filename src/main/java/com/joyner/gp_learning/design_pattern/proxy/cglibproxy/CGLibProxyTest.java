package com.joyner.gp_learning.design_pattern.proxy.cglibproxy;

import com.joyner.gp_learning.design_pattern.proxy.jdkproxy.Customer;
import net.sf.cglib.core.DebuggingClassWriter;

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
public class CGLibProxyTest {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:/gitSpace/gp-learning-demo/target/classes");
        CGLibMeipo cgLibMeipo = new CGLibMeipo();
        Customer customer = (Customer)cgLibMeipo.getInstance(Customer.class);
        customer.findLove();
    }
}
