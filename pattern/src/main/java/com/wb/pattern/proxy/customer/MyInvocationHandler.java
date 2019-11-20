package com.wb.pattern.proxy.customer;

import java.lang.reflect.Method;

/**
 *  自己定义的invocationHandler
 * @author wangbo
 * @since 2019/11/4 10:48
 */
public interface MyInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

}
