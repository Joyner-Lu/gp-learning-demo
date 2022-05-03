package com.joyner.gp_learning.zookeeper.my_distributed_lock.core;

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
public interface Lock {

    /**
     * 尝试获取锁
     * @param lock
     */
    public void tryLock(String lock);


    public void unLock(String lock);


}
