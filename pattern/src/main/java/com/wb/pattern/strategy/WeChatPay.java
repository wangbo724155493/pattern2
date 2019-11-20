package com.wb.pattern.strategy;

/**
 *  微信支付
 * @author wangbo
 * @since 2019/11/4 16:18
 */
public class WeChatPay implements Pay{
    @Override
    public void pay(Double amount, String id) {
        System.out.println("微信支付 账户id为" + id + "     扣除" + amount + "金额");
    }
}
