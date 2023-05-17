package com.slfx.jdkProxy;

import com.slfx.cglib.mapper.Dao;
import com.slfx.cglib.mapper.IDao;
import com.slfx.jdkProxy.proxy.DaoJdkProxy;

import java.lang.reflect.Proxy;


public class Client {


    public static void main(String[] args) {
        //保存动态代理的文件
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        IDao dao = (IDao) Proxy.newProxyInstance(
                Dao.class.getClassLoader(),        // 代理类加载器
                Dao.class.getInterfaces(),         // 代理的接口
                new DaoJdkProxy(new Dao()));
        dao.select();

    }
}
