package com.joyner.gp_learning.design_pattern.strategy.promotion;

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
public class PromotionStrategyFactory {

    private PromotionStrategyFactory() {}

    private static Map<String, PromotionStrategy> strategies = new HashMap<>();

    static {

        strategies.put("COUPON", new CouponStrategy());
        strategies.put("CASH_BACK", new CashBackStrategy());
        strategies.put("GROUP_BUY", new GroupBuyStrategy());
    }

    public static PromotionStrategy getPromotionStrategy(String promotionKey) {
        return strategies.get(promotionKey);
    }
}
