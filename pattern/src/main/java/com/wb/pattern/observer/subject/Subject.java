package com.wb.pattern.observer.subject;

import com.wb.pattern.observer.core.Event;
import com.wb.pattern.observer.core.IEventLisenter;

/**
 * @author wangbo
 * @since 2019/11/7 10:54
 */
public class Subject implements ISubject,IEventLisenter{

    public Event add(){
        System.out.println("调用添加方法");
        return trigger(SubjectEventType.ON_ADD);
    }

    public Event remove(){
        System.out.println("调用删除方法");
        return trigger(SubjectEventType.ON_REMOVE);
    }
}
