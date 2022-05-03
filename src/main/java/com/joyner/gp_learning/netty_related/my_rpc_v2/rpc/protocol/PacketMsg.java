package com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.protocol;

import lombok.Data;

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
public class PacketMsg {

    public PacketMsg(){}

    public PacketMsg(PacketHeader packetHeader, PacketContent packetContent) {
        this.packetHeader = packetHeader;
        this.packetContent = packetContent;
    }

    private PacketHeader packetHeader;
    private PacketContent packetContent;
}
