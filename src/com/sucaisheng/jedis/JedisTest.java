package com.sucaisheng.jedis;

import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        //连接Redis服务器
        Jedis jedis = new Jedis("localhost",6379);
        //存入数据
        jedis.set("username","sucaisheng");
        //关闭连接
        jedis.close();
    }
}
