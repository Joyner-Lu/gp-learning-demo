package com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.protocol;

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
public class PacketContent implements Serializable {


    public PacketContent() {

    }

    public PacketContent(String serviceName, String methodName, Object[] params, Class<?>[] paramTypes) {
        this.serviceName = serviceName;
        this.methodName = methodName;
        this.params = params;
        this.paramTypes = paramTypes;
    }

    private String serviceName;
    private String methodName;
    private Object[] params;
    private Class<?>[] paramTypes;
    private Object res;
}
