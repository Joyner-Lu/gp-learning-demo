package com.joyner.gp_learning.custom_classloader;

import com.sun.org.apache.regexp.internal.RE;

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
public class MyClassLoaderV3 extends ClassLoader {


    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> clz = findLoadedClass(name);
        if (clz != null) {
            return clz;
        } else {

        }
       return findClass(name);
    }

    @Override
    protected Class<?> findClass(String name) {
        String clazzRootPath = MyClassLoaderV3.class.getResource("/").getPath();
        String filePath = clazzRootPath + name.replaceAll("\\.", "/") + ".class";

        Class<?> clzResult = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                clzResult = getSystemClassLoader().loadClass(name);
                return clzResult;
            }
            byte[] clzBytes = getClassBytes(file);
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
        MyClassLoaderV3 myClassLoader = new MyClassLoaderV3();
        Class c = Class.forName("com.joyner.gp_learning.App",true, myClassLoader);
        System.out.println(c.getClassLoader());
        System.out.println(c.newInstance());
    }
}
