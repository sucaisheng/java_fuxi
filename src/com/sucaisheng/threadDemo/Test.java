package com.sucaisheng.threadDemo;

/**
 * 包子线程案列测试类
 */
public class Test {
    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();
        //包子铺线程
        new BaoZiPu(baoZi).start();
        //吃货线程
        new ChiHuo(baoZi).start();
    }
}
