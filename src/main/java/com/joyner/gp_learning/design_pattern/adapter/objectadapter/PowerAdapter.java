package com.joyner.gp_learning.design_pattern.adapter.objectadapter;

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
public class PowerAdapter implements DC5 {
    private AC220 ac220;
    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5V() {
        int input = ac220.outputAC220V();
        int output = input /44;
        System.out.println("使用PowerAdapter，输入AC：" + input + "V,输出DC：" + output + "V");
        return output;
    }
}
