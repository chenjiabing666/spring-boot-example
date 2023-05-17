package com.example.reflectdemo;

/*
 *  @ author  zengqingfa
 *  @ created in    2020/3/8  19:58
 *
 */

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        //通过反射获取Class对象
        Class stuClass = Class.forName(getValue("className"));
        //2获取show()方法
        Method m = stuClass.getMethod(getValue("methodName"));//show
        //3.调用show()方法
        m.invoke(stuClass.getConstructor().newInstance());

    }

    //此方法接收一个key，在配置文件中获取相应的value
    public static String getValue(String key) throws IOException {
        Properties pro = new Properties();//获取配置文件的对象
        FileReader in = new FileReader("D:\\idea\\project08\\springboot-examples\\springboot-examples-demo\\src\\main\\resources\\prop.properties");//获取输入流
        pro.load(in);//将流加载到配置文件对象中
        in.close();
        return pro.getProperty(key);//返回根据key获取的value值
    }

}
