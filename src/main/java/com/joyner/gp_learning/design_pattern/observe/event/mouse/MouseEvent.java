package com.joyner.gp_learning.design_pattern.observe.event.mouse;

import java.util.EventObject;

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
public class MouseEvent extends EventObject {

    private MouseEventType mouseEventType;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MouseEvent(Object source, MouseEventType mouseEventType) {
        super(source);
        this.mouseEventType = mouseEventType;
    }
}
