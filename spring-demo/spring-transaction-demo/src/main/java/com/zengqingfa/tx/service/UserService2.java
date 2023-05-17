package com.zengqingfa.tx.service;

import com.zengqingfa.tx.dao.UserDao;
import com.zengqingfa.tx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @fileName: UserService2
 * @author: zengqf3
 * @date: 2021-7-19 11:12
 * @description:
 */
@Service
public class UserService2 {


    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    /**
     * 标注了@Transactional的方法A的propagation配置成了REQUIRE，
     * 标注了@Transactional的方法B的propagation配置成了REQUIRE_NEW，方法A调用了方法B
     * REQUIRE表示如果当前有事务，则加入事务；如果当前没事务，则新起一个事务；
     * REQUEIRE_NEW表示不管当前是否有事务，都新起一个事务
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void save8() {
        User user = new User();
        user.setName("service2-8");
        user.setAge(8);
        userDao.save(user);
        userService.save82();
        int i = 1/0;
    }

    public List<User> query() {
       return userDao.queryList();
    }
}
