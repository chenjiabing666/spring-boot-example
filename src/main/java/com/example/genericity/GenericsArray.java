package com.example.genericity;

/*
 *  @ author  zengqingfa
 *  @ created in    2020/3/8  19:26
 *
 */

public class GenericsArray<T> {
    private Object[] array;
    public GenericsArray(int size){
        array=new Object[size];
    }

    public void put(int index,T item){
        array[index]=item;
    }

    public T getIndex(int index){
        return (T) array[index];
    }
}
