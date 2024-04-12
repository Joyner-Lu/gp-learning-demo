package com.joyner.gp_learning.rpc.client;

import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.Data;

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
@Data
public class ClientPool {

    private NioSocketChannel[] nioSocketChannel;
    private int size;
    private Object[] locks;

    public ClientPool(int size) {
        this.size = size;
        nioSocketChannel = new NioSocketChannel[size];
        locks = new Object[size];
        for (int i = 0; i < size; i++) {
            locks[i] = new Object();
        }
    }

}
