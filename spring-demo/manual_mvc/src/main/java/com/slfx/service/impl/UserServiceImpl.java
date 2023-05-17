package com.slfx.service.impl;

import com.slfx.bean.User;
import com.slfx.service.UserService;
import com.springmvc.annotation.Service;

/**
 * @author slfx
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {


    public void findUser() {
        System.out.println("====调用UserServiceImpl==findUser===");
    }

    public User getUser() {

        return new User(1, "老王", "admin");
    }

}
