package com.joyner.gp_learning.design_pattern.observe.jdk;

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
public class ObserveTest {

    public static void main(String[] args) {
        GPer gper = GPer.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher mic = new Teacher("Mic");
        gper.addObserver(tom);
        gper.addObserver(mic); //业务逻辑代码
        Question question = new Question();
        question.setUsername("小明");
        question.setContent("观察者模式适用于哪些场景？");
        gper.publishQuestion(question);
    }
}
