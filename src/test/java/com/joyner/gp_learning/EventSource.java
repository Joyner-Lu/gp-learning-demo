package com.joyner.gp_learning;

import java.util.ArrayList;
import java.util.List;

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
public class EventSource<T> {
    private final List<T> eventListeners;

    public EventSource() {
        eventListeners = new ArrayList<T>();
    }

    public synchronized void registerListener(T eventListener) {
        this.eventListeners.add(eventListener);
        this.notifyAll();
    }

    public synchronized List<T> retrieveListeners() throws InterruptedException {
        List<T> dest = null;
        if (eventListeners.size() <= 0) {
            this.wait(); //没有监听器注册到这里，就阻塞该线程。
        }
        dest = new ArrayList<T>(eventListeners.size());
        dest.addAll(eventListeners);
        return dest;
    }

}
