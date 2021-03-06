package com.joyner.gp_learning.design_pattern.decorator.battercake.v2;

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
public class BatterCakeTest {

    public static void main(String[] args) {
        BatterCake batterCake = new BaseBatterCake();

        batterCake = new EggDecorator(batterCake);
        batterCake = new EggDecorator(batterCake);

        System.out.println(batterCake.getMsg() + " " + batterCake.getPrice());

    }
}
