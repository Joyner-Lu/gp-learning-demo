package com.joyner.gp_learning.netty_related.my_rpc_v2.config;

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
public class Configuration {

    public static final int CLIENT_SOCKET_NUMS = 1;//客户端连接数
    public static final int SERVER_SELECTOR_NUMS = 1;

    public static final int PROTOCOL_HTTP = 1;
    public static final int PROTOCOL_CUSTOM_RPC = 2;

    public static final int PROTOCOL = PROTOCOL_CUSTOM_RPC;//使用的协议
}
