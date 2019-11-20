package com.wb.pattern.prototype.deep;

import java.io.Serializable;

/**
 * @author wangbo
 * @since 2019/10/25 16:13
 */
public class Person implements Serializable{
    private String name;

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
