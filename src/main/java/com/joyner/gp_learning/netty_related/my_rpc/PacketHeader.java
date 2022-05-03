package com.joyner.gp_learning.netty_related.my_rpc;

import lombok.Data;

import java.io.Serializable;

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
@Data
public class PacketHeader implements Serializable {

    public PacketHeader() {

    }


    public PacketHeader(int flag, long requestId, int dataLen) {
        this.flag = flag;
        this.requestId = requestId;
        this.dataLen = dataLen;
    }

    private int flag;//可以包括版本号，协议类型，以及其他的等
    private long requestId;//请求ID
    private int dataLen;//数据的长度。

}
