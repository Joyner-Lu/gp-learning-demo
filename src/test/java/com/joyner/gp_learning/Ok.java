package com.joyner.gp_learning;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

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
public class Ok extends TestAbstract {

    private byte[] _1m = new byte[1024*1024];

    public static void main(String[] args) {
        List<Ok> l = new ArrayList<>();
        SoftReference softReference = new SoftReference(l);

        while (true) {
            Ok o = new Ok();
            l.add(o);

        }
    }
}
