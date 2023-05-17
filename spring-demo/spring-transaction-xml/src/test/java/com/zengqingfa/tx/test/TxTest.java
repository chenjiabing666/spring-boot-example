package com.zengqingfa.tx.test;

import com.zengqingfa.tx.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zengqingfa
 * @className Test
 * @description
 * @create 2022/7/24 17:20
 */
public class TxTest {


    @Test
    public void testInsert() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into t_user (name, age) values (?, ?)";
        int result = jdbcTemplate.update(sql, "zhangsan", 22);
        System.out.println(result);
    }

    @Test
    public void testBatchInsert() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into t_user (name, age) values (?, ?)";
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{"zhangsan1",21});
        list.add(new Object[]{"zhangsan2",22});
        list.add(new Object[]{"zhangsan3",23});
        int[] result = jdbcTemplate.batchUpdate(sql, list);
        for (int i : result) {
            System.out.println(i);
        }
    }

    @Test
    public void testQueryForObject() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 69);
        System.out.println(user);
    }

    @Test
    public void testQueryForList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from t_user where id > ?";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), 1);
       users.forEach(user -> {
           System.out.println(user);
       });
    }

    @Test
    public void testQueryForAgg() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select max(age) from t_user ";
       Integer maxAge = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(maxAge);
    }

    @Test
    public void testForMap() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        NamedParameterJdbcTemplate jdbcTemplate = context.getBean("namedParameterJdbcTemplate", NamedParameterJdbcTemplate.class);
        String sql = "insert into t_user (name, age) values (:name,:age)";
        Map<String,Object> map = new HashMap<>();
        map.put("name","lisi");
        map.put("age",33);
        int update = jdbcTemplate.update(sql, map);
        System.out.println(update);
    }
}