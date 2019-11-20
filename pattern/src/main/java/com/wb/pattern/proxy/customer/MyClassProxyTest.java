package com.wb.pattern.proxy.customer;

import com.wb.pattern.proxy.Athletes;
import com.wb.pattern.proxy.PingPanger;

/**
 *  自己定义动态代理测试类
 * @author wangbo
 * @since 2019/11/4 11:36
 */
public class MyClassProxyTest {
    public static void main(String[] args) {

        Athletes obj = (Athletes) new MyProxyDemo(new PingPanger()).getProxyInstance();
        System.out.println(obj);
        obj.train();
        System.out.println();
        obj.match();
    }
}
