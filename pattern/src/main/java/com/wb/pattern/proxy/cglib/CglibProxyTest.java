package com.wb.pattern.proxy.cglib;

/**
 * cglib动态代理测试类
 * @author wangbo
 * @since 2019/11/4 10:30
 */
public class CglibProxyTest {
    public static void main(String[] args) {

        CglibProxy proxy = new CglibProxy();
        PingPanger obj = (PingPanger) proxy.getInstance(PingPanger.class);
        System.out.println(obj.getClass());
        obj.match();
        obj.train();
    }
}
