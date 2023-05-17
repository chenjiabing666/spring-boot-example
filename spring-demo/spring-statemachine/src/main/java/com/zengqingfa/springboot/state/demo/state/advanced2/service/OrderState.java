package com.zengqingfa.springboot.state.demo.state.advanced2.service;

import com.zengqingfa.springboot.state.demo.entity.Order;

/**
 * @author zengqingfa
 * @className OrderState
 * @description
 * @create 2022/10/7 8:55
 */
public interface OrderState {
    //创建订单
    Order create(Order order);
    //发起支付
    Order pay(Long id);
    //订单发货
    Order deliver(Long id);
    //订单收货
    Order receive(Long id);
}