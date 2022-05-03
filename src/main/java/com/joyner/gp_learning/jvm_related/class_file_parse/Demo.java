package com.joyner.gp_learning.jvm_related.class_file_parse;

import com.joyner.gp_learning.jvm_related.exception_code.ExceptionTest;
import lombok.Data;

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
@Data
public class Demo {

    private Integer id;
    private String name;

    public static void main(String[] args) {
        System.out.println(new ExceptionTest());
    }

}
