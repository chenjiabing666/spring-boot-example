package com.example.entity;

/*
 *  @ author  zengqingfa
 *  @ created in    2020/3/8  19:10
 *
 */

public class Person {

    private Integer id;

    private String name;

    public Person(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
