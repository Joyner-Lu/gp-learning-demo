package com.joyner.gp_learning.design_pattern.observe.event.mouse;

import com.joyner.gp_learning.design_pattern.observe.event.door.DoorListener1;
import com.joyner.gp_learning.design_pattern.observe.event.door.DoorListener2;
import com.joyner.gp_learning.design_pattern.observe.event.door.DoorManager;

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
public class MouseManageTest {

    public static void main(String[] args) {

        MouseManage manager = new MouseManage();

        manager.addMouseListener(new MouseListener() {
            @Override
            public void onClick(MouseEvent mouseEvent) {
                System.out.println("鼠标被点击了11");
            }
        });// 给门1增加监听器

        manager.addMouseListener(new MouseListener() {
            @Override
            public void onClick(MouseEvent mouseEvent) {
                System.out.println("鼠标被点击了");
            }
        });// 给门2增加监听器


        manager.fireMouseClick();





    }
}
