package com.joyner.gp_learning.design_pattern.observe.push_subscribe.mouseevent;

import com.joyner.gp_learning.design_pattern.observe.push_subscribe.core.EventPublisher;

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
public class Mouse extends EventPublisher {

    public void click(){
        System.out.println("调用单击方法");
        this.trigger(MouseEventType.ON_CLICK);
    }

    public void doubleClick(){
        System.out.println("调用双击方法");
        this.trigger(MouseEventType.ON_DOUBLE_CLICK);
    }

    public void up(){
        System.out.println("调用弹起方法");
        this.trigger(MouseEventType.ON_UP);
    }

    public void down(){
        System.out.println("调用按下方法");
        this.trigger(MouseEventType.ON_DOWN);
    }

    public void move(){
        System.out.println("调用移动方法");
        this.trigger(MouseEventType.ON_MOVE);
    }

    public void wheel(){
        System.out.println("调用滚动方法");
        this.trigger(MouseEventType.ON_WHEEL);
    }

    public void over(){
        System.out.println("调用悬停方法");
        this.trigger(MouseEventType.ON_OVER);
    }

    public void blur(){
        System.out.println("调用获焦方法");
        this.trigger(MouseEventType.ON_BLUR);
    }

    public void focus(){
        System.out.println("调用失焦方法");
        this.trigger(MouseEventType.ON_FOCUS);
    }
}
