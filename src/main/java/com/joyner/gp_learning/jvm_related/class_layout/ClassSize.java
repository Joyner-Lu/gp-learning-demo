package com.joyner.gp_learning.jvm_related.class_layout;

import com.joyner.gp_learning.design_pattern.proxy.static_proxy.OrderService;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.ConcurrentHashMap;

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
public class ClassSize {

    public static void main(String[] args) {

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
      /*  synchronized (o) {
            int i =0 ;
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

        System.out.println("=========================");
        Object[] arr = new Object[3];
        System.out.println(ClassLayout.parseInstance(arr).toPrintable());*/
    }
}
