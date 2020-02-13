package com.joyner.gp_learning.design_pattern.observe.push_subscribe;


import com.joyner.gp_learning.design_pattern.observe.push_subscribe.mouseevent.Mouse;
import com.joyner.gp_learning.design_pattern.observe.push_subscribe.mouseevent.MouseEventCallback;
import com.joyner.gp_learning.design_pattern.observe.push_subscribe.mouseevent.MouseEventType;

/**
 * Created by Tom on 2019/3/17.
 */
public class MouseEventTest {
    public static void main(String[] args) {

        MouseEventCallback callback = new MouseEventCallback();

        Mouse mouse = new Mouse();

        //@谁？  @回调方法
        mouse.addEventListener(MouseEventType.ON_CLICK,callback);
        mouse.addEventListener(MouseEventType.ON_FOCUS,callback);

        mouse.click();

        mouse.focus();


    }
}
