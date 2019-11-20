package com.wb.pattern.decorator;

/**
 * @author wangbo
 * @since 2019/11/6 16:36
 */
public class ManDecoratorA implements IPerson {

    private IPerson person;

    public ManDecoratorA(IPerson person) {
        this.person = person;
    }

    @Override
    public void eat() {
        System.out.println("吃饭前洗手");
        person.eat();
        System.out.println("吃饭后擦嘴！");
    }
}
