package com.wb.pattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  JDK动态代理
 * @author wangbo
 * @since 2019/11/4 9:20
 */
public class JDKProxy implements InvocationHandler{


    private Object target;

    public JDKProxy(Object target){
        this.target = target;
    }

    public Object newProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("==================打印日志前====================");
        Object obj = method.invoke(target,args);
        System.out.println("==================打印日志后====================");
        return obj;
    }
}
