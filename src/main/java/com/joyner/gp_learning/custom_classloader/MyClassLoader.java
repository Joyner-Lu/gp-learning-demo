package com.joyner.gp_learning.custom_classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

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
public class MyClassLoader extends ClassLoader {

    private static final String MY_CLASS_LOADER_BASE_PATH = "D:/my_classes/";

    @Override
    protected Class<?> findClass(String name) {
        Class<?> clzResult = null;
        try {
            String clzPhysicalPath = name.replaceAll("\\.","/") + ".class";
            byte[] clzBytes = getClassBytes(new File(MY_CLASS_LOADER_BASE_PATH + clzPhysicalPath));
            clzResult = this.defineClass(name, clzBytes, 0, clzBytes.length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return clzResult;

    }

    private byte[] getClassBytes(File file) throws Exception {
        // 这里要读入.class的字节，因此要使用字节流
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true) {
            int i = fc.read(by);
            if (i == 0 || i == -1)
                break;
            by.flip();
            wbc.write(by);
            by.clear();
        }

        fis.close();

        return baos.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class c = Class.forName("com.joyner.gp_learning.App",true, myClassLoader);
        System.out.println(c.getClassLoader());
        System.out.println(c.newInstance());
    }
}
