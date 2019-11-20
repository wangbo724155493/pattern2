package com.wb.pattern.observer.subject;

import com.wb.pattern.observer.core.Event;

/**
 * @author wangbo
 * @since 2019/11/7 10:56
 */
public class ObServer {

    /**
     * 通知方法
     */
    public void advice(Event event){
        System.out.println("========触发事件，打印日志========== \r\n" + event);
    }
}
