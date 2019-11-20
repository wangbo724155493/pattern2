package com.wb.pattern.decorator;

/**
 * @author wangbo
 * @since 2019/11/6 16:38
 */
public class DecoratorTest {
    public static void main(String[] args) {
        IPerson person = new ManDecoratorB(new Man());
        person.eat();
    }
}
