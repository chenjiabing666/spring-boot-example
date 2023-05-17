package com.example.annotation;

/*
 *  @ author  zengqingfa
 *  @ created in    2020/3/7  20:20
 *
 */

@TestAnnotation(id = 123, msg = "hello")
public class MyTest {

    public static void main(String[] args) {
        Class clazz = MyTest.class;
        boolean hasAnnotation = clazz.isAnnotationPresent(TestAnnotation.class);
        if (hasAnnotation) {
            TestAnnotation annotation = (TestAnnotation) clazz.getAnnotation(TestAnnotation.class);
            if (annotation != null) {

            }
        }
    }
}
