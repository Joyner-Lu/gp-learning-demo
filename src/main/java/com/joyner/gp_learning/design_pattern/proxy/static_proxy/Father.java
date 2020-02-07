package com.joyner.gp_learning.design_pattern.proxy.static_proxy;

import com.joyner.gp_learning.design_pattern.proxy.Person;

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
public class Father implements Person {

    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    @Override
    public void findLove() {
        System.out.println("父母物色对象");
        son.findLove();
        System.out.println("双方父母同意交往，确立关系");
    }

    @Override
    public String test001(String param) {
        System.out.println("father test");
        return "ok-father";
    }

    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLove();
    }
}
