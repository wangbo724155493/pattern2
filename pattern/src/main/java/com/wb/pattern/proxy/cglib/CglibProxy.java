package com.wb.pattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *  cglib动态代理
 * @author wangbo
 * @since 2019/11/4 10:31
 */
public class CglibProxy implements MethodInterceptor{

    /**
     * 获取对象
     * @param clazz
     * @return
     * @throws Exception
     */
    public Object getInstance(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        //设置要把那个class设置为即将生成类的夫类
        enhancer.setSuperclass(clazz);

        enhancer.setCallback(this);

        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("==================打印日志前====================");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("==================打印日志后====================");
        return o1;
    }
}
