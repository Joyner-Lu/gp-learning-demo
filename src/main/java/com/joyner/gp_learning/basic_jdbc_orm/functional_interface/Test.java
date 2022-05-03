package com.joyner.gp_learning.basic_jdbc_orm.functional_interface;

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
@FunctionalInterface
public interface Test {

    //这里使用函数式表达式创建了一个Test实例，默认就是实现接口的create()方法
    Test t = (()->{
        return new Test1();
    });

    //创建的是Test1对象
    public Test1 create();

}

class Test1 {


    public static void main(String[] args) {
        Test t1 = Test.t;
        t1.create();
    }

}