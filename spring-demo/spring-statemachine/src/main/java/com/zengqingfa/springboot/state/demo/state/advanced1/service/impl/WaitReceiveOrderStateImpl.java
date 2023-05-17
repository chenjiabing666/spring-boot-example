package com.zengqingfa.springboot.state.demo.state.advanced1.service.impl;

import com.zengqingfa.springboot.state.demo.entity.Order;
import com.zengqingfa.springboot.state.demo.enums.OrderStatus;
import com.zengqingfa.springboot.state.demo.state.advanced1.service.OrderState;
import org.springframework.stereotype.Service;

/**
 * @author zengqingfa
 * @className WaitReceiveOrderStateImpl
 * @description
 * @create 2022/10/6 22:36
 */
@Service
public class WaitReceiveOrderStateImpl extends OrderState {

    @Override
    public void handle(Order order) {
        //TODO 处理待收货的业务
        System.out.println("WaitReceiveOrderStateImpl");
    }

    @Override
    public OrderStatus getOrderStatus() {
        return OrderStatus.WAIT_RECEIVE;
    }
}