package com.wb.pattern.strategy;

/**
 * 策略模式调用client
 * @author wangbo
 * @since 2019/11/4 16:13
 */
public class PayClinet {
    public static void main(String[] args) {
        Order order = new Order("0001",5000.0,"01");

        order.pay(PayType.valueOf("ALI_PAY"));

        order.pay(PayType.valueOf("WE_CHAT_PAY"));
    }
}
