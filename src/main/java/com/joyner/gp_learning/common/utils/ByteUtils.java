package com.joyner.gp_learning.common.utils;

import javax.xml.bind.SchemaOutputResolver;

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
public class ByteUtils {


    public static String toBinaryString(byte b) {
        //保留低8位。例如byte是11001010，则如果直接转为int,则为11111111 11111111 11111111 11001010
        //0xFF 就是00000000 00000000 00000000 11111111（高位自动为0），那么byte &0xFF之后就会变为
        //byte & 0xFF: 00000000 00000000 00000000 11001010
        int convert = b & 0xFF;
        String binaryStr = Integer.toBinaryString(convert);
        while (binaryStr.length() < 8) {
            binaryStr = "0" + binaryStr;
        }
        return binaryStr;
    }

    public static String toHexString(byte b) {
        int convert = b & 0xFF;
        String hexString = Integer.toHexString(convert);
        while (hexString.length() < 2) {
            hexString = "0" + hexString;
        }
        return hexString;
    }

    /**
     * 获取的是补码
     *
     * @param i
     * @return
     */
    public static byte[] intToBytesComplementCode(int i) {
        byte[] result = new byte[4];
        result[3] = (byte) (i & 0x000000FF);//获取第一个字节
        result[2] = (byte) ((i & 0x0000FF00) >> 8);
        result[1] = (byte) ((i & 0x00FF0000) >> 16);
        result[0] = (byte) ((i & 0xFF000000) >> 24);//最高位
        return result;
    }

    public static byte[] intToBytesInverseCode(int i) {
        if (i >= 0) {
            return intToBytesComplementCode(i);
        }
        //反码就是补码减1
        int sub = i - 1;
        return intToBytesComplementCode(sub);
    }

    /**
     * 获取某个数的原码
     *
     * @param i
     * @return
     */
    public static byte[] intToBytesOriginalCode(int i) {
        if (i >= 0) {
            return intToBytesComplementCode(i);
        }
        //原码就是反码保持符号位不变，其余位数取反
        byte[] result = new byte[4];
        byte[] bytes = intToBytesInverseCode(i);
        //取反
        result[3] = (byte) (~(bytes[3] & 0xFF));
        result[2] = (byte) (~(bytes[2] & 0xFF));
        result[1] = (byte) (~(bytes[1] & 0xFF));
        byte tempByte = (byte) (~(bytes[0] & 0xFF));


        char highestBit = toBinaryString(bytes[0]).toCharArray()[0];
        if (highestBit == '0') {
            //用0111 1111(0x7F)来进行&的处理。保持为0.
            int temp = 0x7F;
            result[0] = (byte) ((tempByte & 0xFF) & temp);

        } else if (highestBit == '1') {
            //用1000 0000(0x80)来进行|的处理。保持高位为1
            int temp = 0x80;
            result[0] = (byte) ((tempByte & 0xFF) | temp);
        }

        return result;
    }

    public static void main(String[] args) {
        //-----------------
        int i = 8;
        byte[] r = intToBytesComplementCode(i);
        StringBuilder sb = new StringBuilder();
        for (byte b : r) {
            sb.append(toBinaryString(b) + " ");
        }
        System.out.println(i + "的补码：" + sb.toString());
        sb.setLength(0);
        //-----------------
        r = intToBytesInverseCode(i);
        sb = new StringBuilder();
        for (byte b : r) {
            sb.append(toBinaryString(b) + " ");
        }
        System.out.println(i + "的反码：" + sb.toString());
        sb.setLength(0);

        //-----------------
        r = intToBytesOriginalCode(i);
        sb = new StringBuilder();
        for (byte b : r) {
            sb.append(toBinaryString(b) + " ");
        }
        System.out.println(i + "的原码：" + sb.toString());
        sb.setLength(0);

    }
}
