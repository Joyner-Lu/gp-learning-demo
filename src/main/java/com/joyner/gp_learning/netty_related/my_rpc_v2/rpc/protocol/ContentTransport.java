package com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.protocol;

import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;

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
public interface ContentTransport {


    CompletableFuture<Object> transport(PacketContent packetContent, InetSocketAddress address);


}
