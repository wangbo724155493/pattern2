package com.wb.pattern.observer.subject;


import com.wb.pattern.observer.core.Event;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangbo
 * @since 2019/11/7 11:39
 */
public class SubjectProxy implements InvocationHandler {

    private Object traget;

    public Object newProxyInstance(Object traget){
        this.traget = traget;
        return Proxy.newProxyInstance(traget.getClass().getClassLoader(),traget.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object obj = method.invoke(traget,args);
        if(obj instanceof SubjectEventType){
            SubjectEventType type = (SubjectEventType)obj;
//            event.getCallback().invoke(event.getTarget(),event);

        }
        return obj;
    }
}
