package com.joyner.gp_learning.netty_related.my_rpc_v2.rpc;

import com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.protocol.PacketMsg;

import java.util.concurrent.CompletableFuture;
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
public class ResponseMappingCallback {


    private static volatile ResponseMappingCallback mappingCallback;
    private static ConcurrentHashMap<Long, CompletableFuture<Object>> callbackMap = new ConcurrentHashMap();

    private ResponseMappingCallback() {
        throw new RuntimeException("不能重复创建实例");
    }


    public static ResponseMappingCallback getInstance() {
        if (mappingCallback == null) {
            synchronized (ResponseMappingCallback.class) {
                if (mappingCallback == null) {
                    mappingCallback = new ResponseMappingCallback();
                }
            }
        }
        return mappingCallback;
    }

    public static void addCallBack(long requestId, CompletableFuture callback) {
        callbackMap.putIfAbsent(requestId, callback);
    }

    public static void runCallBack(PacketMsg msg) {
        long requestId = msg.getPacketHeader().getRequestId();
        callbackMap.get(requestId).complete(msg.getPacketContent().getRes());
        deleteCallBack(requestId);
    }

    public static void deleteCallBack(long requestId) {
        callbackMap.remove(requestId);
    }


    public Object readResolve() {
        //防止反序列号
        return mappingCallback;
    }
}
