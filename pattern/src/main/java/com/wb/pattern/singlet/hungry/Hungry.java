package com.wb.pattern.singlet.hungry;

/**
 *  饿汉式单例
 * @author wangbo
 * @since 2019/10/22 16:01
 */
public class Hungry {
    private static final Hungry hungry = new Hungry();

    private Hungry(){
    }

    public static Hungry getInstance(){
        return hungry;
    }
}
