package com.joyner.gp_learning.jvm_related.oom;

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
public class ThreadLocalOOMErrTest {

    public static void main(String[] args) throws Exception{
        ThreadLocal t1 = new ThreadLocal();
        t1.set(new byte[1024*1024*10]);
        t1 = null;

        ThreadLocal t2 = new ThreadLocal();
        t2.set(new byte[1024*1024*10]);
        //t2.remove();
        t2 = null;


        ThreadLocal t3 = new ThreadLocal();
        t3.set(new byte[1024*1024*10]);
        t3 = null;

        /*byte[] bytes1 = new byte[1024*1024*10];
        //bytes1 = null;
        byte[] bytes2 = new byte[1024*1024*10];
        //bytes2 = null;
        byte[] bytes3 = new byte[1024*1024*10];
        //bytes3 = null;
*/
        System.out.println("请按回车键结束程序");
        System.in.read();
        System.out.println("done.");
    }
}
