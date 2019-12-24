package com.joyner.gp_learning.design_pattern.prototype.deep;

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
public class DeepCloneTest {

    public static void main(String[] args) throws Exception {
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        QiTianDaSheng deepCopy = (QiTianDaSheng)qiTianDaSheng.clone();
        System.out.println("深克隆：" + (qiTianDaSheng.jinGuBang == deepCopy.jinGuBang));

        QiTianDaSheng shallowCopy = qiTianDaSheng.shallowClone(qiTianDaSheng);
        System.out.println("浅克隆：" + (qiTianDaSheng.jinGuBang == shallowCopy.jinGuBang));
    }
}
