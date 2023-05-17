package com.zengqingfa.tx;

import com.zengqingfa.tx.entity.User;
import com.zengqingfa.tx.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @author zengqingfa
 * @className App
 * @description
 * @create 2022/7/24 17:16
 */
public class App3 {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.save(new User("zhaoliu", 33));
    }
}