package com.joyner.gp_learning.demo;

import java.io.FileOutputStream;

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
public class TestPileLine {

    public static void main(String[] args) throws Exception {
        int i = 0;
        FileOutputStream fileOutputStream = new FileOutputStream("write.out");
        while (true) {
            i++;
            Thread.sleep(1000);
            fileOutputStream.write((i + "write success!\n").getBytes());
            fileOutputStream.flush();
            if (i > 100000) {
                break;
            }
        }

    }
}
