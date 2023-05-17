package com.example.annotation;

/*
 *  @ author  zengqingfa
 *  @ created in    2020/3/7  20:38
 *
 */

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyTestInherited {
}

/**
 * 父类标注自定义注解
 */
@MyTestInherited
public class Father {

    public void test(){
        System.out.println("father....");
    }

    @Deprecated
    public void test1(){
        System.out.println("father....");
    }
}

/**
 * 子类
 */
class Son extends Father {

    @Override
    public void test(){
        System.out.println("son....");
    }
}

/**
 * 测试子类获取父类自定义注解
 */
class Test {
    public static void main(String[] args) {
        //获取Son的class对象
        Class<Son> sonClass = Son.class;
        // 获取Son类上的注解MyTestAnnotation可以执行成功
        MyTestInherited annotation = sonClass.getAnnotation(MyTestInherited.class);
        System.out.println(33);
    }
}
