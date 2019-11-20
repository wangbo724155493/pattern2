package com.wb.pattern.decorator;

/**
 * @author wangbo
 * @since 2019/11/6 16:36
 */
public class ManDecoratorB implements IPerson {
    IPerson person;
    public ManDecoratorB(IPerson person) {
        this.person = person;
    }

    @Override
    public void eat() {
        System.out.println("========");
        person.eat();
        System.out.println("===========！");
    }
}
