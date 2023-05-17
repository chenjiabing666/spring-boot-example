package com.example.annotation;

/*
 *  @ author  zengqingfa
 *  @ created in    2020/3/8  12:08
 *
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface Check {
    String value();
}


@TestAnnotation(msg = "hello")
public class Test1 {

    @Check("filed")
    public String name;

    @Check("method")
    public void method() {
        System.out.println("method....");
    }

    public static void main(String[] args) {
        boolean hasAnnotation = Test1.class.isAnnotationPresent(TestAnnotation.class);
        if (hasAnnotation) {
            TestAnnotation testAnnotation = Test1.class.getAnnotation(TestAnnotation.class);
            //获取类的注解
            System.out.println("id:" + testAnnotation.id());
            System.out.println("msg:" + testAnnotation.msg());
        }
        try {
            Field a = Test1.class.getDeclaredField("name");
            a.setAccessible(true);
            //获取一个成员变量上的注解
            Check check = a.getDeclaredAnnotation(Check.class);
            if (check != null) {
                System.out.println("check value:" + check.value());
            }
            Method testMethod = Test1.class.getDeclaredMethod("method");
            if (testMethod != null) {
                // 获取方法中的注解
                java.lang.annotation.Annotation[] ans = testMethod.getAnnotations();
                for (int i = 0; i < ans.length; i++) {
                    System.out.println("method testMethod annotation:" + ans[i].annotationType().getSimpleName());
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
