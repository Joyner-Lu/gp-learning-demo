package com.joyner.gp_learning.design_pattern.strategy.pay;

import org.omg.CORBA.PRIVATE_MEMBER;

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
public class PayStrategy {

    private PayStrategy() {}

    public static final String ALI_PAY = "ALI_PAY";
    public static final String JD_PAY = "JD_PAY";
    public static final String UNION_PAY = "UNION_PAY";
    public static final String WE_CHAT_PAY = "WE_CHAT_PAY";
    public static final String DEFAULT_PAY = ALI_PAY;

    private static Map<String, Payment> paymentStrategies = new HashMap<>();

    static {
        paymentStrategies.put(ALI_PAY, new AliPay());
        paymentStrategies.put(JD_PAY, new JDPay());
        paymentStrategies.put(UNION_PAY, new UnionPay());
        paymentStrategies.put(WE_CHAT_PAY, new WeChatPay());

    }

    public static Payment getPayment(String payKey) {
        if (!paymentStrategies.containsKey(payKey)) {
            return paymentStrategies.get(DEFAULT_PAY);
        }
        return paymentStrategies.get(payKey);
    }


}
