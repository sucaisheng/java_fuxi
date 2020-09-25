package com.sucaisheng.annotationUseDemo;

/**
 * 编写几个方法，使用Check注解进行检测是否存在bug
 */
public class Demo {
    //求和
    @Check
    public void add(){
        String a = null;
        System.out.println(a.toString());
        System.out.println("1 + 2 = " + (1 + 2));
    }

    //减法
    @Check
    public void sub(){
        System.out.println("1 - 2 = " + (1 - 2));
    }

    //除法
    @Check
    public void dis(){
        System.out.println("1 / 0 = " + (1 / 0));
    }

    //乘法
    @Check
    public void chen(){
        System.out.println("2 * 3 = " + (2 * 3));
    }

    public void show(){
        System.out.println("Test....");
    }
}
