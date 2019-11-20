package com.wb.pattern.observer.core;

import java.lang.reflect.Method;

/**
 * @author wangbo
 * @since 2019/11/7 10:57
 */
public class Event {

    // 事件源
    private Object source;
    // 通知目标
    private Object target;
    // 回调
    private Method callback;
    // 触发
    private String trigger;

    // 事件
    private Long time;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public Object getSource() {
        return source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ",\n target=" + target +
                ",\n callback=" + callback +
                ",\n trigger='" + trigger + '\'' +
                '}';
    }
}
