package com.joyner.gp_learning.java_basic.rate_limiter;

import com.google.common.util.concurrent.RateLimiter;

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
public class TestRateLimiter {

    public static void main(String[] args) {
        //1秒产生1个令牌
        final RateLimiter rateLimiter = RateLimiter.create(1);
        for (int i = 0; i < 10; i++) {
            //该方法会阻塞线程，直到令牌桶中能取到令牌为止才继续向下执行。
            double waitTime= rateLimiter.acquire();
            System.out.println("任务执行" + i + "等待时间" + waitTime);
        }
        System.out.println("执行结束");
    }
}
