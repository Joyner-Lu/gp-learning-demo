package com.joyner.gp_learning;

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

public class ThisEscape {

    public final int id;
    public final String name;
    public ThisEscape(EventSource<AEventListener> eventSource) {
        id = 1;
        eventSource.registerListener(
                new AEventListener() {
                    @Override
                    public void onEvent(Object object) {
                        System.out.println("id:" + ThisEscape.this.id);
                        System.out.println("name:" + ThisEscape.this.name);
                    }

                });
        try {
            TimeUnit.SECONDS.sleep(1);//此处加入相关断点。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = "thisEscape test.";
    }
}
