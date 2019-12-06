package com.joyner.gp_learning.design_principle_01.principle.liskov_substitution;

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
public class LiskovSubstitutionTest {

    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() <= rectangle.getLength()) {
            //自增宽度
            rectangle.setWidth(rectangle.getWidth() + 1);
            System.out.println("width:" + rectangle.getWidth() + ",length:" + rectangle.getLength());

        }
        System.out.println("end-width:" + rectangle.getWidth() + ",length:" + rectangle.getLength());
    }

    public static void main(String[] args) {
   /*     Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setLength(20);
        resize(rectangle);*/
       Square square = new Square();
       square.setLength(20);
       resize(square);
    }
}
