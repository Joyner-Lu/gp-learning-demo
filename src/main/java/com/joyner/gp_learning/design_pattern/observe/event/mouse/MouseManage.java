package com.joyner.gp_learning.design_pattern.observe.event.mouse;

import com.joyner.gp_learning.design_pattern.observe.event.door.DoorEvent;
import com.joyner.gp_learning.design_pattern.observe.event.door.DoorListener;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

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
public class MouseManage {


    private Collection listeners;


    /**
     * 添加事件
     *
     * @param listener
     * DoorListener
     */

    public void addMouseListener(MouseListener listener) {

        if (listeners == null) {

            listeners = new HashSet();

        }

        listeners.add(listener);

    }


    /**
     * 移除事件
     *
     * @param listener
     * DoorListener
     */

    public void removeMouseListener(MouseListener listener) {

        if (listeners == null)

            return;

        listeners.remove(listener);

    }


    /**
     * 触发鼠标点击事件
     */

    protected void fireMouseClick() {

        if (listeners == null)

            return;

        MouseEvent event = new MouseEvent(this, MouseEventType.ON_CLICK);
        notifyListeners(event);

    }


    /**
     * 通知所有的DoorListener
     */

    private void notifyListeners(MouseEvent event) {

        Iterator iter = listeners.iterator();

        while (iter.hasNext()) {

            MouseListener listener = (MouseListener) iter.next();

            listener.onClick(event);

        }

    }
}
