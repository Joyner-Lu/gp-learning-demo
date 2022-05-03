package com.joyner.gp_learning.design_pattern.state;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class Collage extends State{

    @Override
    public void handle(StateModeContext context) {
        System.out.println("当前状态是 上大学 do something end");
    }

}