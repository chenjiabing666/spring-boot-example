package com.zengqingfa.springboot.state.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zengqingfa.springboot.state.demo.entity.Order;
import com.zengqingfa.springboot.state.demo.enums.OrderStatusChangeEvent;

import java.util.Map;

/**
 * @author zengqingfa
 * @className OrderService
 * @description
 * @create 2021/11/25 20:23
 */
public interface OrderService extends IService<Order> {
    //创建订单
    Order create(Order order);
    //发起支付
    Order pay(Long id);
    //订单发货
    Order deliver(Long id);
    //订单收货
    Order receive(Long id);
}