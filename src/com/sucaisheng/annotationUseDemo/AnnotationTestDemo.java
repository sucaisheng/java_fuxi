package com.sucaisheng.annotationUseDemo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 练习使用自定义注解
 *   编写一个程序测试一段程序里面的方法是否有异常，如果有，记录异常信息并打印在bug.txt文本中
 */
public class AnnotationTestDemo {
    public static void main(String[] args) {
        //创建需要测试的方法的类
        Demo demo = new Demo();
        //获取到类的class
        Class<? extends Demo> demoClass = demo.getClass();

        //创建BufferedWriter
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("bug.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //定义一个变量记录出现异常的方法次数
        int number = 0;

        //获取类里面的所有方法
        Method[] methods = demoClass.getMethods();
        //遍历所有方法
        for (Method method : methods) {
            //判断方法上是否有Check注解,如果有，进行运行检查
            if (method.isAnnotationPresent(Check.class)){
                try {
                    method.invoke(demo);
                } catch (Exception e) {
                    number++;
                    try {
                        //将错误信息写入到bug.txt文件里面
                        bufferedWriter.write(method.getName() + "方法出现了异常！");
                        bufferedWriter.newLine();
                        bufferedWriter.write("异常名称" + e.getCause().getClass().getSimpleName());
                        bufferedWriter.newLine();
                        bufferedWriter.write("异常原因" + e.getCause().getMessage());
                        bufferedWriter.newLine();
                        bufferedWriter.write("------------------");
                        bufferedWriter.newLine();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        }
        try {
            bufferedWriter.write("本次检查一共有" + number + "个方法异常！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //关闭数据流
        try {
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
