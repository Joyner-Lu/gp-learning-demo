package com.joyner.gp_learning.design_pattern.observe.event.door;

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

public class DoorListener2 implements DoorListener {


    @Override

    public void doorEvent(DoorEvent event) {

// TODO Auto-generated method stub

        if (event.getDoorState() != null && event.getDoorState().equals("open")) {

            System.out.println("门2打开，同时打开走廊的灯");

        } else {

            System.out.println("门2关闭，同时关闭走廊的灯");

        }

    }


}