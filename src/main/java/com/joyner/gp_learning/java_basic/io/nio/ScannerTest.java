package com.joyner.gp_learning.java_basic.io.nio;

import java.util.Scanner;

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
public class ScannerTest {

    public static void main(String[] args) {
        //TODO Scanner的问题：https://blog.csdn.net/kiki_jay/article/details/82315653
        //在@Test无法输入
        // TODO 自动生成的方法存根
        Scanner scanner = new Scanner(System.in);  //创建一个扫描器对象，用于接收键盘数据
        System.out.println("请输入：");
        while (scanner.hasNext()) {   //判断是否有输入内容
            String str=scanner.next();//进行读取输入内容
            System.out.println("输入内容为"+str); //打印出来
            /**
             * 问题：我们输入的是Hello world，输出的是Hello
             * 原因：next()	读取数据当看见空格默认结束
             */
        }
    }
}
