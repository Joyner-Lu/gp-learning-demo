package com.joyner.gp_learning.design_pattern.observe.homework_with_guava;

import com.google.common.eventbus.Subscribe;

import java.util.Observable;
import java.util.Observer;

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
public class Teacher {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Subscribe
    public void update(Question question) {
        GPer gPer = (GPer) question.getSource();
        System.out.println(name + "老师，你好！\n" + "您收到了一个来自“" + gPer.getName() + "”的提问，希望您解答，问题内容如下：\n" + question.getContent() + "\n"
                +     "提问者：" + question.getUsername());
    }
}
