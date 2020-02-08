package com.joyner.gp_learning.design_pattern.delegate.simple;

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
public class SimpleDelegateTest {

    public static void main(String[] args) {
        //客户请求（Boss）、委派者（Leader）、被被委派者（Target）
        // 委派者要持有被委派者的引用
        // 代理模式注重的是过程， 委派模式注重的是结果
        // 策略模式注重是可扩展（外部扩展），委派模式注重内部的灵活和复用
        // 委派的核心：就是分发、调度、派遣
        // 委派模式：就是静态代理和策略模式一种特殊的组合
        Boss boss = new Boss();
        boss.command("加密", new Leader());
    }
}


