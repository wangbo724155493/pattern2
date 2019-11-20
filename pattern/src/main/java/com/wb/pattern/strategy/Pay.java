package com.wb.pattern.strategy;

/**
 *  支付接口
 * @author wangbo
 * @since 2019/11/4 16:06
 */
public interface Pay {

    /**
     * 支付
     */
    void pay(Double amount,String id);
}
