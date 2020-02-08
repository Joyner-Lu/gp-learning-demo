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
public class GroupBuyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("拼团，满20人成团，全团享受团购价格");
    }
}
