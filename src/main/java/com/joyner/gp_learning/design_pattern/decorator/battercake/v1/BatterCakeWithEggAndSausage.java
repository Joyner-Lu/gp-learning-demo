package com.joyner.gp_learning.design_pattern.decorator.battercake.v1;

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
public class BatterCakeWithEggAndSausage extends BatterCakeWithEgg {
    @Override
    protected String getMsg() {
        return super.getMsg() + "add 1 sausage";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
