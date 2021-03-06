package com.joyner.gp_learning.design_pattern.observe.event.door;

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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 事件源对象，在这里你可以把它想象成一个控制开门关门的遥控器，
 * (如果是在swing中，就类似一个button)
 */



public class DoorManager {

    private Collection listeners;


    /**
     * 添加事件
     *
     * @param listener
     * DoorListener
     */

    public void addDoorListener(DoorListener listener) {

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

    public void removeDoorListener(DoorListener listener) {

        if (listeners == null)

            return;

        listeners.remove(listener);

    }


    /**
     * 触发开门事件
     */

    protected void fireWorkspaceOpened() {

        if (listeners == null)

            return;

        DoorEvent event = new DoorEvent(this, "open");

        notifyListeners(event);

    }


    /**
     * 触发关门事件
     */

    protected void fireWorkspaceClosed() {

        if (listeners == null)

            return;

        DoorEvent event = new DoorEvent(this, "close");

        notifyListeners(event);

    }


    /**
     * 通知所有的DoorListener
     */

    private void notifyListeners(DoorEvent event) {

        Iterator iter = listeners.iterator();

        while (iter.hasNext()) {

            DoorListener listener = (DoorListener) iter.next();

            listener.doorEvent(event);

        }

    }

}