package com.joyner.gp_learning.slf4j_related;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class HelloSlf4j {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("test");
        logger.error("Hello World");
    }
}
