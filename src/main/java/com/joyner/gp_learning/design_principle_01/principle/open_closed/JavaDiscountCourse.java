package com.joyner.gp_learning.design_principle_01.principle.open_closed;

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
public class JavaDiscountCourse extends JavaCourse {

    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getOriginalPrice() {
        return super.getPrice();
    }

    public Double getPrice() {
        return super.getPrice() * 0.61;
    }
}
