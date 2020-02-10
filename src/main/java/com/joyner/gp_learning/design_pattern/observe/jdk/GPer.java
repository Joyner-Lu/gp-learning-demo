package com.joyner.gp_learning.design_pattern.observe.jdk;

import java.util.Observable;

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
public class GPer extends Observable {

    private String name = "GPer 生态圈";
    private transient static GPer gper = null;

    private GPer() {}

    public static GPer getInstance() {
        if (gper == null) {
            synchronized (GPer.class) {
                if (gper == null) {
                    gper = new GPer();
                }
            }
        }
        return gper;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.getUsername() +"在" + getName()
        + "提交了一个问题");
        setChanged();
        notifyObservers();
    }
}
