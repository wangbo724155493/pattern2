package com.wb.pattern.proxy.staticed;

import com.wb.pattern.proxy.PingPanger;

/**
 *  静态代理测试类
 * @author wangbo
 * @since 2019/11/1 15:42
 */
public class StaticProxyTest {
    public static void main(String[] args) {

        AthletesProxy proxy = new AthletesProxy(new PingPanger());
        proxy.train();
    }
}
