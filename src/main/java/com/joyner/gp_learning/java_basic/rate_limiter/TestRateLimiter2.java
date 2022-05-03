package com.joyner.gp_learning.java_basic.rate_limiter;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

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
public class TestRateLimiter2 {

    public static void main(String[] args) {
        final RateLimiter rateLimiter = RateLimiter.create(1);

        for (int i = 0; i < 10; i++) {
            long timeOut = (long) 0.5;
            boolean isValid = rateLimiter.tryAcquire(timeOut, TimeUnit.SECONDS);
            System.out.println("任务" + i + "执行是否有效:" + isValid);
            if (!isValid) {
                continue;
            }
            System.out.println("任务" + i + "在执行");
        }
        System.out.println("结束");
    }
}
