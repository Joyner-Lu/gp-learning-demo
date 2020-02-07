package com.joyner.gp_learning.design_pattern.proxy.gpproxy;

import com.joyner.gp_learning.design_pattern.proxy.Person;
import com.joyner.gp_learning.design_pattern.proxy.jdkproxy.Customer;

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
public class GPProxyTest {

    public static void main(String[] args) {
        GPMeipo gpMeipo = new GPMeipo();
        Person person = (Person) gpMeipo.getInstance(new Customer());
        person.findLove();
    }
}
