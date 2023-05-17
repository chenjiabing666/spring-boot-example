package com.zengqingfa.springboot.state.demo.state.advanced2.service.impl;

import com.zengqingfa.springboot.state.demo.entity.Order;
import com.zengqingfa.springboot.state.demo.state.advanced2.service.OrderState;

/**
 * @author zengqingfa
 * @className PaymentState
 * @description 待发货 只能发货
 * @create 2022/10/7 8:56
 */
public class WaitDeliverOrderState implements OrderState {

    @Override
    public Order create(Order order) {
        return null;
    }

    @Override
    public Order pay(Long id) {
        return null;
    }

    @Override
    public Order deliver(Long id) {
        return null;
    }

    @Override
    public Order receive(Long id) {
        return null;
    }
}