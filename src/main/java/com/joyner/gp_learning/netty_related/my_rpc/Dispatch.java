package com.joyner.gp_learning.netty_related.my_rpc;

import java.util.concurrent.ConcurrentHashMap;

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
public class Dispatch {

    private static ConcurrentHashMap<String, Object> invokerMap = new ConcurrentHashMap<>();

    private volatile static Dispatch dispatch;

    private Dispatch() {
        if (dispatch != null) {
            throw new RuntimeException("不能创建多个实例");
        }
    }

    public static Dispatch getInstance() {
        if (dispatch == null) {
            synchronized (Dispatch.class) {
                if (dispatch == null) {
                    dispatch = new Dispatch();
                }
            }
        }
        return dispatch;
    }


    public void register(String serviceName, Object invoker) {
        invokerMap.put(serviceName, invoker);
    }

    public Object getInvoker(String serviceName) {
        return invokerMap.get(serviceName);
    }


    public Object readResolve() {
        return dispatch;
    }


}
