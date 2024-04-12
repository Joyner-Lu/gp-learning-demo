package com.joyner.gp_learning.rpc.server;

import com.joyner.gp_learning.rpc.client.IRpcDemo;

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
public class RpcDemoImpl implements IRpcDemo {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
