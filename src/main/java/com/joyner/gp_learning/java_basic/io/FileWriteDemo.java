package com.joyner.gp_learning.java_basic.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class FileWriteDemo {

    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        System.in.read();//block
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        bufferedOutputStream.write("hello world!".getBytes());
        bufferedOutputStream.flush();
        bufferedOutputStream.close();



    }
}
