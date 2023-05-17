package com.zengqingfa.springboot.state.demo;


import com.zengqingfa.springboot.state.demo.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootJpaDemoApplication {

    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootJpaDemoApplication.class, args);
//        OrderService orderService = (OrderService) context.getBean("orderService");
//        orderService.create();
//        orderService.create();
//        orderService.pay(1);
//        new Thread("客户线程") {
//            @Override
//            public void run() {
//                orderService.deliver(1);
//                orderService.receive(1);
//            }
//        }.start();
//        orderService.pay(2);
//        orderService.deliver(2);
//        orderService.receive(2);
//        System.out.println("全部订单状态：" + orderService.getOrders());
    }

}
