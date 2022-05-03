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
        //2.读取version
        readVersion(is);
        //3.读取常量池
        readConstantPool(is);
        is.close();

    }

    private void readConstantPool(InputStream is) throws Exception {
        //1.读取count
        byte[] bytes = readBytes(u2, is);
        int count = ByteUtils.bytesToInt(bytes);
        System.out.println("constant_pool_count:" + (count - 1));
        //2.开始读取常量类(注意从1开始)
        for (int i = 1; i < count; i++) {
            processConstantPool(is, i);
        }

    }

    private void processConstantPool(InputStream is, int constantIdx) throws Exception {


        byte[] bytes = readBytes(u1, is);
        int accessFlagVal = ByteUtils.bytesToInt(bytes);
        ConstantPoolTypes constantPoolTypes = ConstantPoolTypes.getByAccessFlagVal(accessFlagVal);
        if (constantPoolTypes == null) {
            System.out.println("=====error==========accessFlagVal:" + accessFlagVal);
            return;
        }

        switch (constantPoolTypes) {
            case CONTANT_Utf8_info:
                parseContantUtf8Info(is, constantIdx);
                break;
            case CONSTANT_Long_info:
                System.out.println("CONSTANT_Long_info");
                break;
            case CONSTANT_Float_info:
                System.out.println("CONSTANT_Float_info");
                break;
            case CONSTANT_Double_info:
                System.out.println("CONSTANT_Double_info");
                break;
            case CONSTANT_String_info:
                parseConstantStringInfo(is, constantIdx);
                break;
            case CONSTANT_Integer_info:
                System.out.println("CONSTANT_Integer_info");
                break;
            case CONSTANT_MethodType_info:
                System.out.println("CONSTANT_MethodType_info");
                break;
            case CONSTANT_NameAndType_info:
                parseConstantNameandtypeInfo(is, constantIdx);

                break;
            case CONSTANT_MethodHandle_info:
                System.out.println("CONSTANT_MethodHandle_info");

                break;
            case CONSTANT_InvokeDynamic_info:
                System.out.println("CONSTANT_InvokeDynamic_info");

                break;
            case CONSTANT_InterfaceMethodref_info:
                System.out.println("CONSTANT_InterfaceMethodref_info");
                break;
            case CONSTANT_Methodref_info:
                parseConstantMethodrefInfo(is, constantIdx);
                break;
            case CONSTANT_Fieldref_info:
                parseConstantFieldrefInfo(is, constantIdx);
                break;
            case CONSTANT_Class_inf:
                parseConstantClassInf(is, constantIdx);
                break;
        }
    }

    private void parseConstantNameandtypeInfo(InputStream is, int constantIdx) throws Exception {
        /**
         * CONSTANT_NameAndType_info {
         *     u1 tag;
         *     u2 name_index; //name_index 项的值必须是对常量池的有效索引， 常量池在该索引处的项必须是
         *     CONSTANT_Utf8_info结构，这个结构要么表示特殊的方法名<init>，要么表示一个有效
         *     的字段或方法的非限定名（ Unqualified Name）。
         *     u2 descriptor_index;//descriptor_index 项的值必须是对常量池的有效索引， 常量池在该索引
         *     处的项必须是CONSTANT_Utf8_info结构。
         * }
         */
        byte[] bytes = readBytes(u2, is);
        int nameIndex = ByteUtils.bytesToInt(bytes);
        bytes = readBytes(u2, is);
        int descriptorIndex = ByteUtils.bytesToInt(bytes);
        System.out.println("  #" + constantIdx + " = NameAndType  #" + nameIndex + ":#" + descriptorIndex);


    }

    private void parseContantUtf8Info(InputStream is, int constantIdx) throws Exception {
        /**
         * CONSTANT_Utf8_info {
         *     u1 tag;
         *     u2 length;
         *     u1 bytes[length];
         * }
         */
        byte[] bytes = readBytes(u2, is);
        int length = ByteUtils.bytesToInt(bytes);
        bytes = readBytes(u1*length, is);
        System.out.println("  #" + constantIdx + " = Utf8  " + new String(bytes));


    }

    private void parseConstantStringInfo(InputStream is, int constantIdx) throws Exception {
        /**
         * CONSTANT_Class_info {
         *     u1 tag;
         *     u2 name_index;
         * }
         */
        byte[] bytes = readBytes(u2,is);
        int nameIndex = ByteUtils.bytesToInt(bytes);
        System.out.println("  #" + constantIdx + " = String  #" + nameIndex);

    }



    private void parseConstantClassInf(InputStream is, int constantIdx) throws Exception {
        /**
         * CONSTANT_Class_info {
         *     u1 tag;
         *     u2 name_index;
         * }
         */
        byte[] bytes = readBytes(u2, is);
        int nameIndex = ByteUtils.bytesToInt(bytes);
        System.out.println("  #" + constantIdx + " = Class  #" + nameIndex);



    }

    private void parseConstantFieldrefInfo(InputStream is, int constantIdx) throws Exception {
        /**
         * {
         *     tag:u1,
         *     index:u2,
         *     index:u2
         *
         * }
         */
        byte[] bytes = readBytes(u2, is);
        int index1 = ByteUtils.bytesToInt(bytes);
        bytes = readBytes(u2, is);
        int index2 = ByteUtils.bytesToInt(bytes);
        System.out.println("  #" + constantIdx + " = Fieldref  #" + index1 + ".#" + index2);


    }

    private void parseConstantMethodrefInfo(InputStream is, int constantIdx) throws Exception {
        /**
         * CONSTANT_Methodref_info {
         *     u1 tag;
         *     u2 class_index;
         *     u2 name_and_type_index;
         * }
         */
        byte[] bytes = readBytes(u2, is);
        int classIndex = ByteUtils.bytesToInt(bytes);
        bytes = readBytes(u2, is);
        int nameAndTypeIndex = ByteUtils.bytesToInt(bytes);
        System.out.println("  #" + constantIdx + " = Methodref  #" + classIndex + ".#" + nameAndTypeIndex);


    }

    private void readVersion(InputStream is) throws Exception {
        byte[] bytes = readBytes(u2, is);
        int minuVersion = ByteUtils.bytesToInt(bytes);
        System.out.println("minuVersion:" + minuVersion);

        bytes = readBytes(u2, is);
        int majorVersion = ByteUtils.bytesToInt(bytes);
        System.out.println("majorVersion:" + majorVersion);
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

        byte[] buffer = readBytes(u4, is);;
        StringBuilder sb = new StringBuilder();
        for (byte b : buffer) {
            sb.append(ByteUtils.toHexString(b));
        }
        System.out.println("Magic:" + sb.toString());
    }


    public static byte[] readBytes(int length,InputStream is) throws Exception {
        byte[] bytes = new byte[length];
        is.read(bytes);
        return bytes;
    }



}
