package com.example.genericity;

/*
 *  @ author  zengqingfa
 *  @ created in    2020/3/8  15:22
 *
 */

import java.util.List;

public class GemericityDemo {

    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            // 注意这里得到的n是其上边界类型的, 也就是Number, 需要将其转换为double.
            s += n.doubleValue();
        }
        return s;
    }

    public static void main(String[] args) {
       //T[] arr=new T[];

    }


}
