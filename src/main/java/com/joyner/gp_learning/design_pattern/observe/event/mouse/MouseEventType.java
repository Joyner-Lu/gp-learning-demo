package com.joyner.gp_learning.design_pattern.observe.event.mouse;

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
public enum  MouseEventType {
    //单击
    ON_CLICK("click");

    private String actionType;

    private MouseEventType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionType() {
        return actionType;
    }
}
