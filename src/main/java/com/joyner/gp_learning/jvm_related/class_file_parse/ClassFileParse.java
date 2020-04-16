package com.joyner.gp_learning.jvm_related.class_file_parse;

import com.joyner.gp_learning.common.utils.ByteUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * <pre>
 *  class文件读取
 *
 *  TODO 字节码操作参考如下文章
 *  参考文章：https://www.cnblogs.com/chenjy1225/p/11605618.html
 *  参考文章：https://blog.csdn.net/alvinhuai/article/details/82790888?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-4&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-4
 *
 *  TODO tips:java 中对byte的所有运算操作均会是首先将byte转化为int, 再行运算
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
public class ClassFileParse {

    private static final int u1 = 1;
    private static final int u2 = 2;
    private static final int u4 = 4;
    private static final int u8 = 8;

    public static void main(String[] args) throws Exception {
        String path = "D:\\gitSpace\\gp-learning-demo\\target\\classes\\com\\joyner\\gp_learning\\jvm_related\\class_file_parse\\Demo.class";
        new ClassFileParse().parseClass(path);
    }


    public void parseClass(String classFile) throws Exception {
        File file = new File(classFile);
        InputStream is = new FileInputStream(file);
        //1.读取magic
        readMagic(is);
        is.close();

    }

    private void readMagic(InputStream is) throws Exception {
        /**
         * tips:(1)java 中对byte的所有运算操作均会是首先将byte转化为int, 再行运算
         *      (2)java 打印byte会先转换为int然后在打印
         *
         * 读取：cafebabe（这里注意是10进制的cafebabe，也就是ca才是组成一个字节）
         * 那么这里以读取第一个字节为例byte1
         * （1）读取到第一个字节16进制表示是0xca（也就是ca）,其二进制为：1100 1010
         * （2）调用Integer.toHexString(int)，这个时候传递进去的就是：
         *  11111111 11111111 11111111 1100 1010（byte变成了int,会把最高位当初符号位，这里是1.也就是负数
         *  那么扩展的时候就是不足的补充1）
         *  那么就会输出ff ff ff ca,这并不是我们想要的结果。
         *
         *  （3）调用Integer.toHexString(int)之前先做处理
         *  byte1 & 0xFF 变成
         *  11111111 11111111 11111111 11001010 & 11111111(前面的都是0)
         *  最后的结果就是：00000000 00000000 00000000 1100 1010
         *
         *  Integer.toHexString如果前面是0的不会打印处理。最终就得到了我们想要的字符ca
         *
         *  TODO 注意：如果在代码中直接指定16进制。那么如果不满足32位数，高位都是直接补充0的，例如：
         *  int i = 0xca;  则为:00000000 00000000 00000000 1100 1010
         *  而不是：11111111 11111111 11111111 1100 1010
         *
         *  TODO 如果是从文件中读取的字节，转换的是就是高位是1，则补充1，否则补充0。
         *
         *
         */

        byte[] buffer = new byte[u4];
        int len = is.read(buffer);
        StringBuilder sb = new StringBuilder();
        for (byte b : buffer) {
            System.out.println(ByteUtils.toBinaryString(b));
            sb.append(ByteUtils.toHexString(b));
        }
        System.out.println(sb.toString());
    }






}
