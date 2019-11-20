package com.wb.pattern.decorator;


/**
 * @author wangbo
 * @since 2019/11/6 16:31
 */
public class Man implements IPerson {
    @Override
    public void eat() {
        System.out.println("吃饭！");
    }
}
