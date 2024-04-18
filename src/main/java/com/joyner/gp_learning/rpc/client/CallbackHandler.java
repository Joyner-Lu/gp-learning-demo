package com.joyner.gp_learning.rpc.client;

import com.joyner.gp_learning.rpc.base.RpcResBody;

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
public class CallbackHandler {

    private static ConcurrentHashMap<Long, ICallBackInterface> callbackRegistry = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Long, RpcResBody> responseRegistry = new ConcurrentHashMap<>();

    public static void register(Long requestId, ICallBackInterface callBackInterface) {
        callbackRegistry.put(requestId, callBackInterface);
    }

    public static RpcResBody getResponse(Long requestId) {
        RpcResBody rpcResBody = responseRegistry.get(requestId);
        responseRegistry.remove(requestId);
        return rpcResBody;
    }

    private static void remove(Long requestId) {
        callbackRegistry.remove(requestId);
    }

    //run
    public static void run(Long requestId, RpcResBody rpcResBody) {
        responseRegistry.put(requestId, rpcResBody);
        ICallBackInterface callBackInterface = callbackRegistry.get(requestId);
        if (callBackInterface != null) {
            callBackInterface.run(requestId, rpcResBody);
            //remove
            remove(requestId);
        }
    }
}
