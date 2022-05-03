package com.joyner.gp_learning.netty_related.my_rpc;

import com.joyner.gp_learning.orm_related.mybatis.plugins.PhysicalRowBoundsInterceptor;
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

    public PacketMsg(PacketHeader packetHeader, PacketBody packetBody) {
        this.packetHeader = packetHeader;
        this.packetBody = packetBody;
    }

    private PacketHeader packetHeader;
    private PacketBody packetBody;
}
