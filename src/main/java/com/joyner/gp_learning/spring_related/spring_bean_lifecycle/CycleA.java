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
public class CycleA {

    private CycleB cycleB;

    public CycleA(CycleB cycleB) {
        this.cycleB = cycleB;
    }

   /* public void setCycleB(CycleB cycleB) {
        this.cycleB = cycleB;
    }*/

    public CycleB getCycleB() {
        return cycleB;
    }
}
