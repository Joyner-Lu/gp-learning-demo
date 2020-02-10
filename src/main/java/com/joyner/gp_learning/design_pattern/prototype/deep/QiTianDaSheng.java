package com.joyner.gp_learning.design_pattern.prototype.deep;

import java.io.*;
import java.util.Date;

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
public class QiTianDaSheng extends Monkey implements Serializable {

    public JinGuBang jinGuBang;

    public QiTianDaSheng() {
        //初始化齐天大圣
        this.height = 150;
        this.weight = 120;
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutput objectOutput = new ObjectOutputStream(byteArrayOutputStream);
            objectOutput.writeObject(this);
            byteArrayOutputStream.flush();
            objectOutput.flush();

            ByteArrayInputStream bis =new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(bis);
            QiTianDaSheng qiTianDaSheng = (QiTianDaSheng)objectInputStream.readObject();
            qiTianDaSheng.birthday = new Date();
            return qiTianDaSheng;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public QiTianDaSheng shallowClone(QiTianDaSheng target) {
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        qiTianDaSheng.height = target.height;
        qiTianDaSheng.weight = target.weight;
        qiTianDaSheng.jinGuBang = target.jinGuBang;
        qiTianDaSheng.birthday = new Date();
        return qiTianDaSheng;
    }
}
