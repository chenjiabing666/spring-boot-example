package com.zengqingfa.tx.entity;

import lombok.Data;

/**
 * @fileName: User
 * @author: zengqf3
 * @date: 2021-7-19 8:51
 * @description:
 */
@Data
public class User {

    private Integer id;
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
