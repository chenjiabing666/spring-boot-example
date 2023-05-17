package com.example.mybatis.plus.demo;

import com.example.entity.Person;
import com.example.genericity.GenericFruit;
import com.example.genericity.Generical;
import com.example.genericity.GenericalArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MybatisPlusDemoApplicationTests {

    @Test
    public void contextLoads() {
        List<String> strList = new ArrayList<String>();
        List<Integer> intList = new ArrayList<Integer>();

        Class strClass = strList.getClass();
        Class intClass = intList.getClass();
        System.out.println(strClass.equals(intClass));//true
    }

    @Test
    public void test02() {
        //未指定
        Generical generical1 = new Generical();
        generical1.setKey(123);
        generical1.setKey("123");
        //制定类型
        Generical<Integer> generical = new Generical<>();
        generical.setKey(13232);
        System.out.println(generical);
    }

    @Test
    public void test03() {
        Generical<Integer> gInteger = new Generical<Integer>();
        gInteger.setKey(11);
        Generical<Number> gNumber = new Generical<Number>();


// showKeyValue这个方法编译器会为我们报错：Generic<java.lang.Integer>
// cannot be applied to Generic<java.lang.Number>
// showKeyValue(gInteger);

    }

    @Test
    public void test04(){
        Person[] persons=new GenericalArray().getArray(Person.class,5);
        System.out.println(Arrays.toString(persons));
        for (int i = 0; i <persons.length ; i++) {
            persons[i]=new Person(i);
        }
        System.out.println(Arrays.toString(persons));
    }

}
