package com.zengqingfa.springboot.state.demo.state.advanced1.service;

import com.zengqingfa.springboot.state.demo.entity.Order;
import com.zengqingfa.springboot.state.demo.enums.OrderStatus;
import lombok.Data;

/**
 * 订单状态接口
 */
@Data
public abstract class OrderState {


    /**
     * 处理与状态相关的业务信息
     *
     * @param order
     */
    public abstract void handle(Order order);

    public abstract OrderStatus getOrderStatus();
}

