package com.joyner.gp_learning.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
public class ObjectUtils {

    public static byte[] objToBytes(Object obj) {
        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            return stream.toByteArray();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static <T>T bytesToObj(byte[] bytes, Class<T> clz) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object obj = objectInputStream.readObject();
            return (T)obj;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
