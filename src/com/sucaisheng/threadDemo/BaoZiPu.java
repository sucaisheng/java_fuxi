package com.sucaisheng.threadDemo;

/**
 * 包子铺继承Thread类
 *   用包子对象作为锁对象
 *   对包子状态进行判断
 *     如果没有包子，包子铺生产包子
 *     如果有包子，包子铺调用wait()方法进入休眠，将包子状态变成true,唤醒吃货来吃包子
 */
public class BaoZiPu extends Thread{
    private BaoZi baoZi;

    public BaoZiPu(BaoZi baoZi){
        this.baoZi = baoZi;
    }

    //重写run方法

    @Override
    public void run() {
        int count = 0;
        //死循环让包子铺一直生产包子
        while(true){
            //用包子对象作为锁对象，实现同步代码块
            synchronized (baoZi){
                //判断包子的状态
                if (baoZi.flag == true){
                    //包子状态是有的状态，调用wait()方法，包子铺停止生产等待
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else{
                    //包子状态为没有，包子铺生产包子
                    System.out.println("包子铺正在生产包子，请等待！");
                    //两种味道的包子选择
                    if (count % 2 == 0){
                        baoZi.pi = "薄皮";
                        baoZi.xian = "三鲜馅";
                    }else{
                        baoZi.pi = "厚皮";
                        baoZi.xian = "牛肉馅";
                    }
                    try {
                        //生产包子需要6秒
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    baoZi.flag = true;
                    System.out.println(baoZi.pi + baoZi.xian + "包子好了！");
                    //包子生产好了，唤醒吃货来吃包子
                    baoZi.notify();
                }
            }
        }
    }
}
