package com.joyner.gp_learning.rpc.server;

import java.util.concurrent.ConcurrentHashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class ServerRegistry {

    private static ConcurrentHashMap<String, Class<?>> registry = new ConcurrentHashMap<>();

    static {
        registry.put("com.joyner.gp_learning.rpc.client.IRpcDemo", RpcDemoImpl.class);
    }

    //get
    public static Class<?> get(String serviceName) {
        return registry.get(serviceName);
    }
}
