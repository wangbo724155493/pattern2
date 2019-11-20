package com.wb.pattern.observer.mouse;

import com.wb.pattern.observer.core.EventLisenter;

/**
 * 被观察者
 * @author wangbo
 * @since 2019/11/7 14:34
 */
public class Mouse extends EventLisenter{

    public void click(){
        System.out.println("点击事件======");
        trigger(MouseEventType.ON_CLICK);
    }

    public void doubelClick(){
        System.out.println("双击事件======");
        trigger(MouseEventType.ON_DOUBLE_CLICK);
    }
}
