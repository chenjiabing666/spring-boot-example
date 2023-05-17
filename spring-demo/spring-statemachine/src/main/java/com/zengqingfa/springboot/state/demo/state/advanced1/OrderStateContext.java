package com.zengqingfa.springboot.state.demo.state.advanced1;


import com.zengqingfa.springboot.state.demo.entity.Order;
import com.zengqingfa.springboot.state.demo.state.advanced1.service.OrderState;
import lombok.Data;

/**
 * 状态上下文
 */
@Data
public class OrderStateContext {


    /**
     * 当前订单状态
     */
    private OrderState orderState;


    public OrderStateContext(OrderState orderState) {
        this.orderState = orderState;
    }

    /**
     * 创建订单
     *
     * @param order
     */
    public void create(Order order) {
        this.getOrderState().handle(order);
    }

    /**
     * 支付订单
     *
     * @param order
     */
    public void pay(Order order) {
        this.getOrderState().handle(order);
    }

    /**
     * 待发货
     *
     * @param order
     */
    public void deliver(Order order) {
        this.getOrderState().handle(order);
    }

    /**
     * 确认收货
     *
     * @param order
     */
    public void receive(Order order) {
        this.getOrderState().handle(order);
    }

}

