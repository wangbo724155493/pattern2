package com.wb.pattern.factory.simple;

/**
 *  简单工厂模式测试类
 * @author wangbo
 * @since 2019/10/22 14:28
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        System.out.println(factory.getFruit("苹果"));
    }
}
