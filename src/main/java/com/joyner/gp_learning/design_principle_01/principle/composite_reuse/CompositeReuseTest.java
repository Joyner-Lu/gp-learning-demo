package com.joyner.gp_learning.design_principle_01.principle.composite_reuse;

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
public class CompositeReuseTest {

    public static void main(String[] args) {
        ProductDao dao = new ProductDao();
        dao.setDbConnection(new MySQLConnection());
        dao.addProduct();
    }
}
