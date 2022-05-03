package com.joyner.gp_learning.java_basic.socket.nio_version;

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
public class MainThreadTest {


    public static void main(String[] args) {
        SelectorThreadGroup stgWorker = new SelectorThreadGroup(3);
        SelectorThreadGroup stgBoss = new SelectorThreadGroup(1, stgWorker);
        stgBoss.bind(9090);
    }


}
