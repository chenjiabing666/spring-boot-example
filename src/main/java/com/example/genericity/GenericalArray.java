package com.example.genericity;

/*
 *  @ author  zengqingfa
 *  @ created in    2020/3/8  19:02
 *
 */

import java.lang.reflect.Array;

public class GenericalArray {
    public static <T> T[] getArray(Class<T> componentType, int length) {
        return (T[]) Array.newInstance(componentType, length);
    }
}
