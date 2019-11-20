package com.wb.pattern.factory.func;


/**
 *  工厂方法模式测试类
 * @author wangbo
 * @since 2019/10/22 14:32
 */
public class FuncFactoryTest {
    public static void main(String[] args) {
        FruitFactory factory = new AppleFactory();
        System.out.println(factory.getFruit());
    }
}
