package com.wb.pattern.proxy.jdkproxy;


import com.wb.pattern.proxy.Athletes;
import com.wb.pattern.proxy.PingPanger;

/**
 * JDK动态代理测试类
 * @author wangbo
 * @since 2019/11/1 16:28
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        Athletes obj = (Athletes) new JDKProxy(new PingPanger()).newProxyInstance();
        System.out.println(obj.getClass());
        obj.match();
        System.out.println();
        obj.train();
    }
}
