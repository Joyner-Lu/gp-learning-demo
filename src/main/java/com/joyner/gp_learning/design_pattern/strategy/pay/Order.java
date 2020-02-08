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
public class Order {

    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    /**
     * 完美解决了不写if else的过程
     * @param payKey
     * @return
     */
    public PayState pay(String payKey) {
        Payment payment = PayStrategy.getPayment(payKey);
        System.out.println("欢迎使用" + payment.getName());
        System.out.println("本次交易金额为" + amount);
        return payment.pay(uid, amount);
    }
}
