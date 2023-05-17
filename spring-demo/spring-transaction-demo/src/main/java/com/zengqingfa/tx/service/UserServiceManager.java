package com.zengqingfa.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @fileName: UserServiceManager
 * @author: zengqf3
 * @date: 2021-7-19 11:24
 * @description:
 */
@Component
public class UserServiceManager {

    @Autowired
    private UserService userService;

    /**
     * protect方法只能包内调用,借助外部类调用
     * AbstractFallbackTransactionAttributeSource#getTransactionAttribute
     * org.springframework.transaction.interceptor.AbstractFallbackTransactionAttributeSource#computeTransactionAttribute(java.lang.reflect.Method, java.lang.Class)
     */
    public void save9() {
        userService.save9();
    }
}
