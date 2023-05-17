package com.zengqingfa.tx.dao;

import com.zengqingfa.tx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @fileName: UserDao
 * @author: zengqf3
 * @date: 2021-7-19 9:26
 * @description:
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(User user) {
        jdbcTemplate.update("insert into t_user (name, age) values (?, ?)", user.getName(), user.getAge());
    }

    public List<User> queryList() {
        List<User> users = jdbcTemplate.query("select * from t_user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                return user;
            }
        });
        return users;
    }
}
