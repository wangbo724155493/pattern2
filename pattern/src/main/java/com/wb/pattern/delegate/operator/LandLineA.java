package com.wb.pattern.delegate.operator;

/**
 * @author wangbo
 * @since 2019/11/6 13:58
 */
public class LandLineA implements ILandline{
    @Override
    public void using(String des) {
        System.out.println("我是A座机，这里是：" + des );
    }
}
