package com.wb.pattern.factory.func;

import com.wb.pattern.factory.Bnana;
import com.wb.pattern.factory.Fruit;

/**
 * 香蕉工厂
 * @author wangbo
 * @since 2019/10/22 14:31
 */
public class BnanaFactory implements FruitFactory {
    @Override
    public Fruit getFruit() {
        return new Bnana();
    }
}
