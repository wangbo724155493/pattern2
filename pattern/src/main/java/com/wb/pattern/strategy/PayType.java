package com.wb.pattern.strategy;

/**
 *  支付类型枚举
 * @author wangbo
 * @since 2019/11/4 16:09
 */
public enum PayType {
    ALI_PAY(new AliPay()),
    WE_CHAT_PAY(new WeChatPay());

    private Pay pay;

    PayType(Pay pay){
        this.pay = pay;
    }

    public Pay getPay(){
        return this.pay;
    }
}
