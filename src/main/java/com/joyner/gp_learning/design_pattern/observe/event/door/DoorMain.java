package com.joyner.gp_learning.design_pattern.observe.event.door;

/**
 * <pre>
 *  参考文章：https://blog.csdn.net/weixin_40657079/article/details/82958431
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
/**
 * 主程序，就想象成要开门的哪个人
 */



public class DoorMain {

    public static void main(String[] args) {

        DoorManager manager = new DoorManager();

        manager.addDoorListener(new DoorListener1());// 给门1增加监听器

        manager.addDoorListener(new DoorListener2());// 给门2增加监听器

// 开门

        manager.fireWorkspaceOpened();

        System.out.println("我已经进来了");

// 关门

        manager.fireWorkspaceClosed();

    }

}
