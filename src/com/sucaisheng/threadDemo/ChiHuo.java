package com.sucaisheng.threadDemo;

/**
 * 吃货线程，负责吃包子
 *   对包子状态进行判断，如果包子生产好了，调用wait()方法进行休眠，把包子状态变成false
 *   如果包子没有了，唤醒包子铺生产包子
 */
public class ChiHuo extends Thread{
    private BaoZi baoZi;

    public ChiHuo(BaoZi baoZi){
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        while(true){
            synchronized (baoZi){
                //如果包子的状态为false，吃货进行等待
                if (baoZi.flag == false){
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    //包子状态为true，吃货吃包子
                    System.out.println(baoZi.pi + baoZi.xian + "包子真好吃！");
                    //包子吃完后将包子的状态变成false
                    baoZi.flag = false;
                    //唤醒包子铺生产包子
                    baoZi.notify();
                    System.out.println("--------------------");
                }
            }
        }
    }
}
