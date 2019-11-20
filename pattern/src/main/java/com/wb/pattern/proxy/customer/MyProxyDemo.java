package com.wb.pattern.proxy.customer;

import java.lang.reflect.Method;

/**
 * @author wangbo
 * @since 2019/11/4 11:37
 */
public class MyProxyDemo implements MyInvocationHandler {

    private Object target;

    public MyProxyDemo(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        return MyProxy.newProxyInstance(new MyClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("打印日志前===========");
        Object result = method.invoke(target, args);
        System.out.println("打印日志后===========");
        return result;
    }
}
