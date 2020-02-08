package com.joyner.gp_learning.design_pattern.strategy.pay;

import com.sun.org.apache.xpath.internal.operations.Or;

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
public class PayStrategyTest {

    public static void main(String[] args) {
        Order order = new Order("uid_001", "orderid_001", 3000000);
        System.out.println(order.pay(PayStrategy.ALI_PAY));
    }
}
