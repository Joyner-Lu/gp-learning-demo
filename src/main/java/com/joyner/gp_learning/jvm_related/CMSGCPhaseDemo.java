package com.joyner.gp_learning.jvm_related;

import java.util.ArrayList;
import java.util.List;
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

/**
 * -Xms101m
 * -Xmn50m
 * -Xmx101m
 * -verbose:gc
 * -XX:MetaspaceSize=1m
 * -XX:+UseConcMarkSweepGC
 * -Xloggc:/tmp/gc.log
 * -XX:+PrintGCCause
 * -XX:+PrintGCTimeStamps
 * -XX:+PrintGCDetails
 * -XX:PrintCMSStatistics=1
 * -XX:CMSScheduleRemarkEdenPenetration=50
 * -XX:CMSScheduleRemarkEdenSizeThreshold=2m
 * -XX:CMSMaxAbortablePrecleanTime=5000
 * -XX:+UseCMSInitiatingOccupancyOnly
 * -XX:CMSInitiatingOccupancyFraction=50
 */
public class CMSGCPhaseDemo {
    /**
     * 存活对象
     */
    private static List<DumbObj> liveObjs = new ArrayList<>(5);

    public static void main(String[] args) throws InterruptedException {
//创建新对象触发gc
        for(int i=0;i<25;i++){
            DumbObj dumb = new DumbObj(5, null);
            if(liveObjs.size()<5){
                liveObjs.add(new DumbObj(5, dumb));
            }else{
                dumb.setNext(liveObjs.get(i%5));
            }
        }
        //等待gc线程工作
        TimeUnit.SECONDS.sleep(20);
    }
}
