package com.sucaisheng.kuangjiaDemo;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 *理由反射，写一个可以创建所有类的框架
 */
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties pro = new Properties();
        ClassLoader classLoader = ReflectDemo.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("pro.properties");
        pro.load(in);
        //获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        //加载该类进入内存
        Class cls = Class.forName(className);
        //创建类对象
        Object obj = cls.newInstance();
        //获取此对象方法
        Method method = cls.getMethod(methodName);
        //执行方法
        method.invoke(obj);
    }
}
