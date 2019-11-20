package com.wb.pattern.factory.abstr;

import com.wb.pattern.factory.Fruit;
import com.wb.pattern.factory.func.AppleFactory;
import com.wb.pattern.factory.func.BnanaFactory;

/**
 * @author wangbo
 * @since 2019/10/22 14:38
 */
public class FruitFactory extends AbstractFactory {
    @Override
    public Fruit getApple() {
        return new AppleFactory().getFruit();
    }

    @Override
    public Fruit getBnana() {
        return new BnanaFactory().getFruit();
    }
}
