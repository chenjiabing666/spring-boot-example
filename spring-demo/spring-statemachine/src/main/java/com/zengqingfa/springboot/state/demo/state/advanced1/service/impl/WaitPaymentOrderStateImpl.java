package com.zengqingfa.springboot.state.demo.state.advanced1.service.impl;

import com.zengqingfa.springboot.state.demo.entity.Order;
import com.zengqingfa.springboot.state.demo.enums.OrderStatus;
import com.zengqingfa.springboot.state.demo.state.advanced1.service.OrderState;
import org.springframework.stereotype.Service;

/**
 * @author zengqingfa
 * @className WaitPaymentOrderStateImpl
 * @description
 * @create 2022/10/6 22:36
 */
@Service
public class WaitPaymentOrderStateImpl extends OrderState {


    @Override
    public void handle(Order order) {
        //TODO 处理待支付的业务 创建订单
        System.out.println("WaitPaymentOrderStateImpl");
    }


    @Override
    public OrderStatus getOrderStatus() {
        return OrderStatus.WAIT_PAYMENT;
    }
}