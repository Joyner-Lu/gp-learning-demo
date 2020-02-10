package com.joyner.gp_learning.design_pattern.strategy.pay;

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
public abstract class Payment {

    /**
     * 获取支付类型
     * @return
     */
    public abstract String getName();

    public abstract double queryBalance(String uid);

    public final PayState pay(String uid, double amount) {

        if (queryBalance(uid) < amount) {
            return new PayState("500", "支付失败", "余额不足");
        }
        return new PayState("200", "支付成功", "支付金额：" + amount);
    }


}
