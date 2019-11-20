package com.wb.pattern.strategy;

/**
 * 支付宝
 *
 * @author wangbo
 * @since 2019/11/4 16:11
 */
public class AliPay implements Pay {
    @Override
    public void pay(Double amount, String id) {
        System.out.println("支付宝支付 账户id为" + id + "     扣除" + amount + "金额");
    }
}
