package com.joyner.gp_learning.kafka.demo;

import java.nio.ByteBuffer;

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
public class ByteBufferTest {

    public static void main(String[] args) {
        String name = "joyner";
        String address = "beijing";
        ByteBuffer allocate = ByteBuffer.allocate(4 + 4 + name.length() + address.length());
        allocate.putInt(name.length());
        allocate.put(name.getBytes());
        allocate.putInt(address.length());
        allocate.put(address.getBytes());


        //开始读取
        allocate.flip();
        int anInt = allocate.getInt();
        byte[] nameBytes = new byte[anInt];
        allocate.get(nameBytes);
        int anInt1 = allocate.getInt();
        byte[] addressBytes = new byte[anInt1];
        allocate.get(addressBytes);

        System.out.println(new String(nameBytes));
        System.out.println(new String(addressBytes));

        //开始写
        allocate.clear();
        allocate.putInt(name.length());

        //开始读
        allocate.flip();
        int anInt2 = allocate.getInt();
        System.out.println(anInt2);
        int anInt3 = allocate.getInt();



    }
}
