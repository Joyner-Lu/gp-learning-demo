package com.joyner.gp_learning.juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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
public class ReentrantReadWriteLockDemo {

    static Map<String, Object> cacheMap = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock read = rwl.readLock();
    static Lock write = rwl.writeLock();

    public static Object get(String key) {
        read.lock(); //读锁 ThreadA 阻塞
        try {
            return cacheMap.get(key);
        } finally {
            read.unlock(); //释放读锁
        }
    }

    public static Object write(String key, Object value) {
        write.lock(); //Other Thread 获得了写锁
        try {
            return cacheMap.put(key, value);
        } finally {
            write.unlock();
        }
    }

}
