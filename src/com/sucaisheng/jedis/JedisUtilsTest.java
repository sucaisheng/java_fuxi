package com.sucaisheng.jedis;

import com.sucaisheng.utils.JedisUtils;
import redis.clients.jedis.Jedis;

/**
 * 测试Jedis工具类
 */
public class JedisUtilsTest {
    public static void main(String[] args) {
        Jedis jedis = JedisUtils.getJedis();
        jedis.set("password","123456");
        String password = jedis.get("password");
        System.out.println(password);
        //指定时间（10）秒钟之后删除键和值
        jedis.setex("token", 10, "15185478704");
    }
}
