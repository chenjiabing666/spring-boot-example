package com.zengqingfa.springboot.state.demo.state.advanced1;


import cn.hutool.core.collection.CollUtil;
import com.zengqingfa.springboot.state.demo.enums.OrderStatus;
import com.zengqingfa.springboot.state.demo.state.advanced1.service.OrderState;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 状态上下文
 */
@Component
public class OrderStateContextFactory implements InitializingBean {

    @Resource
    private List<OrderState> orderStateList;


    private Map<OrderStatus, OrderStateContext> map = new HashMap<>();


    @Override
    public void afterPropertiesSet() throws Exception {
        if (CollUtil.isNotEmpty(orderStateList)) {
            orderStateList.forEach(o -> {
                map.put(o.getOrderStatus(),new OrderStateContext(o));
            });
        }
    }

    /**
     * 获取到对应的状态上下文
     *
     * @param orderStatus
     * @return
     */
    public OrderStateContext getContext(OrderStatus orderStatus) {
        return map.get(orderStatus);
    }
}

