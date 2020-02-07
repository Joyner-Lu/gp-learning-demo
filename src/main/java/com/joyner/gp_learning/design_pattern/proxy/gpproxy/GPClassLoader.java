package com.joyner.gp_learning.design_pattern.proxy.gpproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

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
public class GPClassLoader extends ClassLoader{

    private File classPathFile;

    public GPClassLoader() {
        classPathFile = new File(GPClassLoader.class.getResource("").getPath());
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String className = GPClassLoader.class.getPackage().getName() + "." + name;
            if (classPathFile != null) {
                File classFile = new File(classPathFile, name.replaceAll("\\.","/") + ".class");
                if (classFile.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(classFile);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = fileInputStream.read(buffer)) != -1) {
                        byteArrayOutputStream.write(buffer,0 ,len);
                    }

                    return defineClass(className,byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                }
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
