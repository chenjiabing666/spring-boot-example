package com.zengqingfa.tx;

import com.zengqingfa.tx.config.TransactionConfiguration;
import com.zengqingfa.tx.entity.User;
import com.zengqingfa.tx.service.UserService;
import com.zengqingfa.tx.service.UserService2;
import com.zengqingfa.tx.service.UserServiceManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @fileName: TxApplication
 * @author: zengqf3
 * @date: 2021-7-19 8:48
 * @description:
 */
public class TxApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfiguration.class);
        UserService userService = context.getBean(UserService.class);

        UserService2 userService2 = context.getBean(UserService2.class);
        UserServiceManager userServiceManager = context.getBean(UserServiceManager.class);

        List<User> users = userService2.query();
        users.forEach(user -> {
            System.out.println(user);
        });
        //场景一：未开启事务注解 EnableTransactionManagement
//        userService.save1();

        //场景二：标注了@Transactional的方法里面的异常被捕获了
//        userService.save2();

        //场景三：标注了@Transactional的方法发生了非 Error 或者 RuntimeException
//        userService.save3();

        //场景四：标注了@Transactional的方法的事务传播类型propagation配置成了NOTSUPPORT
//        userService.save4();

        //场景五：标注了@Transactional的方法的事务传播类型propagation配置成了NEVER
//        userService.save5();

        //场景六：标注了@Transactional的方法的事务传播类型propagation配置成了SUPPORTS且当前没有事务
//        userService.save6();

        //场景七：外部调用方法A，A内部调用方法B，A没有@Transaction注解而B有@Transactional注解
//        userService.save7();

        //场景八：标注了@Transactional的方法A的propagation配置成了REQUIRE，
        // 标注了@Transactional的方法B的propagation配置成了REQUIRE_NEW，方法A调用了方法B
//        userService2.save8();

        //场景九：标注了@Transactional的方法不是public的
//        userServiceManager.save9();

        //场景十：标注了@Transactional的方法发生的异常不是rollbackFor指定的类型或子类
//        userService.save10();

        //场景十一：数据库不支持事务
        //如果数据库引擎不支持事务的话，随便怎么加@Transactional，都不会生效。
    }
}
