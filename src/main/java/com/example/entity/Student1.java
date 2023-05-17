package com.example.entity;

/*
 *  @ author  zengqingfa
 *  @ created in    2020/3/8  20:28
 *
 */


public class Student1 {
    public Student1() {
    }

    //**********字段*************//
    public String name;
    protected int age;
    char sex;
    private String phoneNum;

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sex=" + sex
                + ", phoneNum=" + phoneNum + "]";
    }

}

