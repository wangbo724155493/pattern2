package com.wb.pattern.factory.abstr;

/**
 *  抽象工厂测试类
 * @author wangbo
 * @since 2019/10/22 14:39
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        FruitFactory factory = new FruitFactory();
        System.out.println(factory.getBnana());
    }
}
