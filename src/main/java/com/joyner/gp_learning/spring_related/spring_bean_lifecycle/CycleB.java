package com.joyner.gp_learning.spring_related.spring_bean_lifecycle;

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
public class CycleB {

    private CycleA cycleA;

    public void setCycleA(CycleA cycleA) {
        this.cycleA = cycleA;
    }

    public CycleA getCycleA() {
        return cycleA;
    }
}
