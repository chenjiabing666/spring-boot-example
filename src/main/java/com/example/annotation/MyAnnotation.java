package com.example.annotation;

/*
 *  @ author  zengqingfa
 *  @ created in    2020/3/7  20:06
 *
 */

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented()
public @interface MyAnnotation {

    String msg();
}
