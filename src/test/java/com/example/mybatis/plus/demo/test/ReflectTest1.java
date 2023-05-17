package com.example.mybatis.plus.demo.test;

/*
 *  @ author  zengqingfa
 *  @ created in    2020/3/8  20:11
 *
 */

import com.example.entity.Book;
import com.example.entity.Student;
import com.example.entity.Student1;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectTest1 {

    //在运行期间，一个类，只有一个Class对象产生。
    @Test
    public void test1() throws Exception {
        Book book = new Book();
        //object 的 getClass方法
        Class<? extends Book> clazz1 = book.getClass();
        //.class方法
        Class clazz2 = Book.class;
        //forName方法
        Class clazz3 = Class.forName("com.example.entity.Book");
        System.out.println(clazz1 == clazz2); //true
        System.out.println(clazz1 == clazz3); //true
    }

    @Test
    public void test03() throws Exception {
        //1.加载Class对象
        Class clazz = Class.forName("com.example.entity.Student");

        //2.获取所有公有构造方法
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] conArray1 = clazz.getConstructors();
        for (Constructor c : conArray1) {
            System.out.println(c);
        }

        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        Constructor[] conArray2 = clazz.getDeclaredConstructors();
        for (Constructor c : conArray2) {
            System.out.println(c);
        }

        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor con1 = clazz.getConstructor(null);
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        //2>、返回的是描述这个无参构造函数的类对象。

        System.out.println("con1 = " + con1);
        //调用构造方法
        Object obj = con1.newInstance();
        //	System.out.println("obj = " + obj);
        //	Student stu = (Student)obj;

        System.out.println("******************获取私有构造方法，并调用*******************************");
        Constructor con2 = clazz.getDeclaredConstructor(char.class);
        System.out.println(con2);
        //调用构造方法
        con2.setAccessible(true);//暴力访问(忽略掉访问修饰符)
        obj = con2.newInstance('男');
    }

    @Test
    public void test04() throws Exception {
        //1.获取Class对象
        Class stuClass = Class.forName("com.example.entity.Student1");
        //2.获取字段
        System.out.println("************获取所有公有的字段********************");
        Field[] fieldArray = stuClass.getFields();
        for (Field f : fieldArray) {
            System.out.println(f);
        }
        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        fieldArray = stuClass.getDeclaredFields();
        for (Field f : fieldArray) {
            System.out.println(f);
        }
        System.out.println("*************获取公有字段**并调用***********************************");
        Field f = stuClass.getField("name");
        System.out.println(f);
        //获取一个对象
        Object obj = stuClass.getConstructor().newInstance();//产生Student对象--》Student stu = new Student();
        //为字段设置值
        f.set(obj, "刘德华");//为Student对象中的name属性赋值--》stu.name = "刘德华"
        //验证
        Student1 stu = (Student1) obj;
        System.out.println("验证姓名：" + stu.name);


        System.out.println("**************获取私有字段****并调用********************************");
        f = stuClass.getDeclaredField("phoneNum");
        System.out.println(f);
        f.setAccessible(true);//暴力反射，解除私有限定
        f.set(obj, "18888889999");
        System.out.println("验证电话：" + stu);

    }

    @Test
    public void test05() throws Exception {
        //1.获取Class对象
        Class stuClass = Class.forName("com.example.entity.Student2");
        //2.获取所有公有方法
        System.out.println("***************获取所有的”公有“方法*******************");
        stuClass.getMethods();
        Method[] methodArray = stuClass.getMethods();
        for (Method m : methodArray) {
            System.out.println(m);
        }
        System.out.println("***************获取所有的方法，包括私有的*******************");
        Method[] methodArray2 = stuClass.getDeclaredMethods();
        for (Method m : methodArray2) {
            System.out.println(m);
        }
        System.out.println("***************获取公有的show1()方法*******************");
        Method m = stuClass.getMethod("show1", String.class);
        System.out.println(m);
        //实例化一个Student对象
        Object obj = stuClass.getConstructor().newInstance();
        m.invoke(obj, "zengqingfa");

        System.out.println("***************获取私有的show4()方法******************");
        Method m1 = stuClass.getDeclaredMethod("show4", int.class);
        System.out.println(m1);
        m1.setAccessible(true);//解除私有限定
        Object result = m1.invoke(obj, 20);//需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("返回值：" + result);
    }

    @Test
    public void test06() throws Exception{
        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");

        //	strList.add(100);
        //获取ArrayList的Class对象，反向的调用add()方法，添加数据
        Class listClass = strList.getClass(); //得到 strList 对象的字节码 对象
        //获取add()方法
        Method m = listClass.getMethod("add", Object.class);
        //调用add()方法
        m.invoke(strList, 100);

        //遍历集合
        for (Object obj : strList) {
            System.out.println(obj);
        }

    }


}
