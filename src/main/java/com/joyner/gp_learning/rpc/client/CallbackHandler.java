package com.joyner.gp_learning.rpc.client;

import com.joyner.gp_learning.rpc.base.RpcResBody;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

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

    private static ConcurrentHashMap<Long, CountDownLatch> latchRegistry = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Long, RpcResBody> responseRegistry = new ConcurrentHashMap<>();

    public static void add(Long requestId, CountDownLatch latch) {
        latchRegistry.put(requestId, latch);
    }

    public static CountDownLatch get(Long requestId) {
        return latchRegistry.get(requestId);
    }

    public static RpcResBody getResponse(Long requestId) {
        RpcResBody rpcResBody = responseRegistry.get(requestId);
        responseRegistry.remove(requestId);
        return rpcResBody;
    }

    public static void remove(Long requestId) {
        latchRegistry.remove(requestId);
    }

    //run
    public static void run(Long requestId, RpcResBody rpcResBody) {
        responseRegistry.put(requestId, rpcResBody);
        CountDownLatch countDownLatch = latchRegistry.get(requestId);
        if (countDownLatch != null) {
            countDownLatch.countDown();
            //remove
            remove(requestId);
        }
    }
}
