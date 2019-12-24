package com.joyner.gp_learning;

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

public class ListenerRunnable implements Runnable {
    private EventSource<AEventListener> source;
    public ListenerRunnable(EventSource<AEventListener> source) {
        this.source = source;
    }
    @Override
    public void run() {
        List<AEventListener> listeners = null;
        try {
            listeners = source.retrieveListeners();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (AEventListener eventListener : listeners) {
            eventListener.onEvent(new Object());
        }
    }
}
