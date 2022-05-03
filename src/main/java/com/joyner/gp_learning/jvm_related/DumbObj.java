package com.joyner.gp_learning.jvm_related;

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
public class DumbObj {
    public DumbObj(int sizeM,DumbObj next) {
        this.data = getM(sizeM);
        this.next = next;
    }
    private Byte[] getM(int m) {
        return new Byte[1024 * 1024 * m];
    }
    private DumbObj next;
    private Byte [] data;

    public DumbObj getNext() {
        return next;
    }

    public void setNext(DumbObj next) {
        this.next = next;
    }

    public Byte[] getData() {
        return data;
    }

    public void setData(Byte[] data) {
        this.data = data;
    }
}