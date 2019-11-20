package com.wb.pattern.observer.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangbo
 * @since 2019/11/7 14:00
 */
public interface IEventLisenter {

    public Map<Enum,Event> events = new HashMap<>();

    public default void addLisenter(Enum eventType, Object target, Method callback){
        // 注册事件
        // 用反射调用这个方法
        events.put(eventType,new Event(target,callback));
    }

    public default Event trigger(Event event){
        event.setSource(this);
        event.setTime(System.currentTimeMillis());

        return event;
//        try {
//            event.getCallback().invoke(event.getTarget(),event);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public default Event trigger(Enum call){
        if(!this.events.containsKey(call)){
            return null;
        }
        return trigger(this.events.get(call).setTrigger(call.toString()));
    }
}
