package com.example.annotation;

/*
 *  @ author  zengqingfa
 *  @ created in    2020/3/8  11:42
 *
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    int id() default -1;

    String msg();
}
