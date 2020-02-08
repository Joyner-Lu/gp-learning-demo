package com.joyner.gp_learning.design_pattern.strategy.promotion;

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
public class PromotionStrategyTest {

    /*public static void main(String[] args) {
        PromotionActivity promotionActivity618 = new PromotionActivity(new CouponStrategy());
        promotionActivity618.execute();
    }*/

   /* public static void main(String[] args) {
        PromotionActivity promotionActivity = null;
        String promotionKey = "COUPON";
        if ("COUPON".equals(promotionKey)) {
            promotionActivity = new PromotionActivity(new CouponStrategy());
        } else if ("CASH_BACK".equals(promotionKey)) {
            promotionActivity = new PromotionActivity(new CashBackStrategy());
        } else if ("GROUP_BUY".equals(promotionKey)) {
            promotionActivity = new PromotionActivity(new GroupBuyStrategy());
        } else {
            promotionActivity = new PromotionActivity(new EmptyStrategy());
        }
        promotionActivity.execute();
    }*/

    public static void main(String[] args) {
        String promotionKey = "COUPON";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionActivity.execute();
    }
}
