package com.joyner.gp_learning.design_pattern.delegate.simple;

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
public class Boss {

    /**
     * 老板自己不干活，委派给leader
     * @param command
     * @param leader
     */
    public void command(String command, Leader leader) {
        leader.doing(command);
    }
}
