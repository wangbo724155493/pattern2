package com.wb.pattern.factory.func;

import com.wb.pattern.factory.Apple;
import com.wb.pattern.factory.Fruit;

/**
 *  苹果工厂
 * @author wangbo
 * @since 2019/10/22 14:31
 */
public class AppleFactory implements FruitFactory {
    @Override
    public Fruit getFruit() {
        return new Apple();
    }
}
