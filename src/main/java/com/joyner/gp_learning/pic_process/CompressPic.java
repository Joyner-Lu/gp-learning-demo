package com.joyner.gp_learning.pic_process;

import net.coobird.thumbnailator.Thumbnails;

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
public class CompressPic {

    public static void main(String[] args) throws Exception {
        Thumbnails.of("D:\\06 高并发负载均衡_网络高并发负载均衡.png").scale(0.4f).toFile("D:\\1高并发负载均衡_网络高并发负载均衡.png");//按比例缩小
    }
}
