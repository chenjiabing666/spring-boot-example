package com.zengqingfa.tx.dao;

import com.zengqingfa.tx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zengqingfa
 * @className UserDao
 * @description
 * @create 2022/7/24 18:33
 */
@Component
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void save(User user) {
        String sql = "insert into t_user (name, age) values (?, ?)";
        int result = jdbcTemplate.update(sql, user.getName(), user.getAge());
        System.out.println(result);
//        System.out.println(1/0);
    }

}