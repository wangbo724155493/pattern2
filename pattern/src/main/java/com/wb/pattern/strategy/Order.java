package com.wb.pattern.strategy;

/**
 *  订单实体
 * @author wangbo
 * @since 2019/11/4 16:08
 */
public class Order {
    private String id;
    private Double amount;
    private String orderId;

    public Order(String id, Double amount, String orderId) {
        this.id = id;
        this.amount = amount;
        this.orderId = orderId;
    }

    /**
     * 业务方法
     * @param payType
     */
    public void pay(PayType payType){
        payType.getPay().pay(this.amount,this.id);
    }
}
