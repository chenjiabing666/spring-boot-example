package com.zengqingfa.tx;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * @author zengqingfa
 * @className App
 * @description
 * @create 2022/7/24 17:16
 */
public class App {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(dataSource);
        System.out.println(jdbcTemplate);
        System.out.println(dataSource.getConnection());
    }
}