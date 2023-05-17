package com.zengqingfa.springboot.state.demo.state.advanced1.controller;

import com.zengqingfa.springboot.state.demo.entity.Order;
import com.zengqingfa.springboot.state.demo.enums.OrderStatus;
import com.zengqingfa.springboot.state.demo.state.advanced1.OrderStateContext;
import com.zengqingfa.springboot.state.demo.state.advanced1.OrderStateContextFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zengqingfa
 * @className OrderController
 * @description
 * @create 2021/11/28 9:49
 */
@RestController
@RequestMapping("/state/order")
public class OrderStateController {


    @Resource
    private OrderStateContextFactory factory;


    /**
     * 创建订单
     *
     * @return
     */
    @RequestMapping("/create")
    public String create(@RequestBody Order order) {
        OrderStateContext orderStateContext = factory.getContext(OrderStatus.WAIT_PAYMENT);
        orderStateContext.create(order);
        return "sucess";
    }

    /**
     * 对订单进行支付
     *
     * @param id
     * @return
     */
    @RequestMapping("/pay")
    public String pay(@RequestParam("id") Long id) {
        //对订单进行支付
        OrderStateContext orderStateContext = factory.getContext(OrderStatus.WAIT_DELIVER);
        Order order = new Order();
        order.setId(id);
        orderStateContext.pay(order);
        return "success";
    }


    /**
     * 对订单进行发货
     *
     * @param id
     * @return
     */
    @RequestMapping("/deliver")
    public String deliver(@RequestParam("id") Long id) {
        //对订单进行确认收货
        OrderStateContext orderStateContext = factory.getContext(OrderStatus.WAIT_RECEIVE);
        Order order = new Order();
        order.setId(id);
        orderStateContext.deliver(order);
        return "success";
    }

    /**
     * 对订单进行确认收货
     *
     * @param id
     * @return
     */
    @RequestMapping("/receive")
    public String receive(@RequestParam("id") Long id) {
        //对订单进行确认收货
        OrderStateContext orderStateContext = factory.getContext(OrderStatus.FINISH);
        Order order = new Order();
        order.setId(id);
        orderStateContext.receive(order);
        return "success";
    }
}