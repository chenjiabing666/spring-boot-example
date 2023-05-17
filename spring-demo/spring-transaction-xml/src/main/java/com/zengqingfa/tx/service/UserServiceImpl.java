package com.zengqingfa.tx.service;

import com.zengqingfa.tx.dao.UserDao;
import com.zengqingfa.tx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zengqingfa
 * @className UserServiceImpl
 * @description
 * @create 2022/7/24 19:26
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }
}