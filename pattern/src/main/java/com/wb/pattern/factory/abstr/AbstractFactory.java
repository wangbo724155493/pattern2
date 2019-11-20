package com.wb.pattern.factory.abstr;

import com.wb.pattern.factory.Fruit;

/**
 * 抽象工厂模式
 * @author wangbo
 * @since 2019/10/22 14:36
 */
public abstract class AbstractFactory {

    public abstract Fruit getApple();

    public abstract Fruit getBnana();
}
