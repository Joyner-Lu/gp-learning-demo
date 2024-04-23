package com.joyner.gp_learning.rpc.client;

import com.joyner.gp_learning.rpc.base.RpcResBody;

import java.util.concurrent.CompletableFuture;
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
public class CallbackHandlerMapping {

    private static ConcurrentHashMap<Long, CompletableFuture> mapping = new ConcurrentHashMap<>();

    public static void register(Long requestId, CompletableFuture completableFuture) {
        mapping.put(requestId, completableFuture);
    }


    private static void remove(Long requestId) {
        mapping.remove(requestId);
    }

    //run
    public static void run(Long requestId, RpcResBody rpcResBody) {

        CompletableFuture completableFuture = mapping.get(requestId);
        //remove
        remove(requestId);
        if (completableFuture == null) {
            return;
        }
        completableFuture.complete(rpcResBody.getResult());
    }
}
