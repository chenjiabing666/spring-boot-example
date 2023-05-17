package com.zengqingfa.springboot.state.demo.config;

import com.zengqingfa.springboot.state.demo.entity.Order;
import com.zengqingfa.springboot.state.demo.enums.OrderStatus;
import com.zengqingfa.springboot.state.demo.enums.OrderStatusChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;


import javax.annotation.Resource;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zengqingfa
 * @className OrderStateMachineConfig
 * @description
 * @create 2021/11/25 20:21
 */
@Configuration
@EnableStateMachine(name = "orderStateMachine")
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderStatus, OrderStatusChangeEvent> {

    /**
     * 配置状态
     *
     * @param states
     * @throws Exception
     */
    public void configure(StateMachineStateConfigurer<OrderStatus, OrderStatusChangeEvent> states) throws Exception {
        states
                .withStates()
                .initial(OrderStatus.WAIT_PAYMENT)
                .states(EnumSet.allOf(OrderStatus.class));
    }

    /**
     * 配置状态转换事件关系
     *
     * @param transitions
     * @throws Exception
     */
    public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderStatusChangeEvent> transitions) throws Exception {
        transitions
                //支付事件:待支付-》待发货
                .withExternal().source(OrderStatus.WAIT_PAYMENT).target(OrderStatus.WAIT_DELIVER).event(OrderStatusChangeEvent.PAYED)
                .and()
                //发货事件:待发货-》待收货
                .withExternal().source(OrderStatus.WAIT_DELIVER).target(OrderStatus.WAIT_RECEIVE).event(OrderStatusChangeEvent.DELIVERY)
                .and()
                //收货事件:待收货-》已完成
                .withExternal().source(OrderStatus.WAIT_RECEIVE).target(OrderStatus.FINISH).event(OrderStatusChangeEvent.RECEIVED);
    }

    /**
     * 持久化配置
     * 实际使用中，可以配合redis等，进行持久化操作,如下使用内存操作，重启则会丢失
     *
     * @return
     */
//    @Bean
//    public DefaultStateMachinePersister persister() {
//        return new DefaultStateMachinePersister<>(new StateMachinePersist<Object, Object, Order>() {
//            @Override
//            public void write(StateMachineContext<Object, Object> context, Order order) throws Exception {
//                //此处进行持久化操作
//                map.put(order, context);
//                System.out.println("此处进行持久化操作");
//            }
//
//            @Override
//            public StateMachineContext<Object, Object> read(Order order) throws Exception {
//                //此处直接获取order中的状态，其实并没有进行持久化读取操作
//                System.out.println("此处直接获取order中的状态，其实并没有进行持久化读取操作");
//                StateMachineContext stateMachineContext = (StateMachineContext) map.get(order);
//                return stateMachineContext;
//            }
//            //使用hashMap操作
//            private Map map = new HashMap();
//        });
//    }

//    @Resource
//    private RedisConnectionFactory redisConnectionFactory;
//
//    @Bean(name = "stateMachineRedisPersister")
//    public RedisStateMachinePersister getRedisPersister() {
//        RedisStateMachineContextRepository repository = new RedisStateMachineContextRepository<>(redisConnectionFactory);
//        RepositoryStateMachinePersist p = new RepositoryStateMachinePersist<>(repository);
//        return new RedisStateMachinePersister<>(p);
//    }
}