package com.wb.pattern.observer.mouse;


/**
 *  观察者
 * @author wangbo
 * @since 2019/11/7 14:38
 */
public class MouseCallback {
    public void onCick(){
        System.out.println("单击事件回调函数");
    }

    public void onDoubleClick(){
        System.out.println("双击事件回调函数");
    }
}
