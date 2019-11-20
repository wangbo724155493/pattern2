package com.wb.pattern.factory.simple;

import com.wb.pattern.factory.Apple;
import com.wb.pattern.factory.Bnana;
import com.wb.pattern.factory.Fruit;

/**
 *  简单工厂模式
 * @author wangbo
 * @since 2019/10/22 14:26
 */
public class SimpleFactory {
    public Fruit getFruit(String name){
        if("苹果".equals(name)){
            return  new Apple();
        }else if("香蕉".equals(name)){
            return new Bnana();
        }
        return null;
    }
}
