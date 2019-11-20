package com.wb.pattern.prototype.simple;

import com.wb.pattern.prototype.deep.Person;

import java.util.ArrayList;
import java.util.List;

/**
 *  原型模式浅克隆
 *
 * @author wangbo
 * @since 2019/10/25 15:48
 */
public class Prototype implements Cloneable{
    private String name;

    private Person person;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype obj1 = new Prototype();
        obj1.setName("张三");
        obj1.setPerson(new Person("as;dkfjaslkjdf"));

        Prototype obj2 = (Prototype) obj1.clone();

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println("=========================");
        // 打印地址值
        System.out.println(obj1.getPerson());
        System.out.println(obj2.getPerson());
    }
}
