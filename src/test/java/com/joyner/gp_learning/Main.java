package com.joyner.gp_learning;

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
public class Main {
    public static void main(String[] args) {
        EventSource<AEventListener> eventSource = new EventSource<AEventListener>();
        ListenerRunnable listenerRunnable = new ListenerRunnable(eventSource);
        new Thread(listenerRunnable).start();
        System.out.println();
        ThisEscape escape = new ThisEscape(eventSource);
        System.out.println(escape);
    }
}
