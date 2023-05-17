package com.zengqingfa.tx;

import com.zengqingfa.tx.dao.UserDao;
import com.zengqingfa.tx.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @author zengqingfa
 * @className App
 * @description
 * @create 2022/7/24 17:16
 */
public class App2 {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.save(new User("zhaoliu", 33));
    }
}